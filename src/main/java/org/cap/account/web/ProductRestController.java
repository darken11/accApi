package org.cap.account.web;
import org.cap.account.entities.Category;
import org.cap.account.entities.Product;
import org.cap.account.metier.CategoryApiService;
import org.cap.account.metier.ProductApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ProductRestController {
    @Autowired
    ProductApiService productRestApi;
    @Autowired
    CategoryApiService categoryApiService;



    @GetMapping(path = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Product> getProducts() {

        return productRestApi.findAll();
    }




    @GetMapping(path = "/product/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Product getProductById(@PathVariable Long productId) {

        return productRestApi.findOne(productId);
    }
    @GetMapping(path = "/search/products")
    @ResponseBody
    public List<Product> search(@Param("mc") String mc){
        return
                productRestApi.findProduct(mc);
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
 Category cat=categoryApiService.findOne(new Long(Integer.parseInt(product.getCategory().getName())));
product.getCategory().setId(cat.getId());
 product.getCategory().setName(cat.getName());
        return productRestApi.save(product);
    }

    @DeleteMapping(path = "/product/{id}")
    public void delete(@PathVariable(value="id") Long id ) throws ResourceNotFoundException {

        Product product= productRestApi.findOne(id);
        if(product ==null){
            throw new  ResourceNotFoundException("Product not found for this id :: " + id);
        }

         productRestApi.delete(product);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id,
                                                  @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRestApi.findOne(id);

        if(product ==null){
            throw new  ResourceNotFoundException("Product not found for this id :: " + id);
        }
        product.setDesignation(productDetails.getDesignation());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.getCategory().setName(productDetails.getCategory().getName());
        final Product updatedProduct = productRestApi.save(product);
        return ResponseEntity.ok(updatedProduct);
    }


}
