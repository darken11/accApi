package org.cap.account.web;

import org.cap.account.entities.Category;
import org.cap.account.entities.Product;
import org.cap.account.metier.CategoryApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryRestController {
    @Autowired
    CategoryApiService categoryApiService;


    @GetMapping(path = "/categories", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Category> getCategories() {

        return categoryApiService.findAll();


    }
    @GetMapping(path="/categories/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Category getCategory(@PathVariable Long id){
        return categoryApiService.findOne(id);
    }
    @DeleteMapping(path = "/categories/{id}")
    public  void deleteCategory(@PathVariable Long id){
        Category cat= categoryApiService.findOne(id);
        if(cat ==null){
            throw new ResourceNotFoundException("Category not found for this id :: " + id);
        }
        categoryApiService.delete(cat);
    }
    @PutMapping(path="/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long id, @Valid @RequestBody Category categoryBodyApi) throws ResourceNotFoundException{
        Category category1=categoryApiService.findOne(id);
        if(category1 ==null){
            throw new ResourceNotFoundException("Category not found for this id :: " + id);
        }
        category1.setName(categoryBodyApi.getName());
        final Category updateCategory=categoryApiService.save(category1);
        return ResponseEntity.ok(updateCategory) ;
    }
    @PostMapping(path = "/categories")
    public Category createCategory(@Valid @RequestBody Category category){
        return  categoryApiService.save(category);
    }
}