package org.cap.account.metier;


import org.cap.account.custumException.ProductException;
import org.cap.account.constants.ApiConstants;
import org.cap.account.entities.*;
import org.cap.account.repository.ProductRestApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductApiServiceImpl implements ProductApiService {
    @Autowired
    private ProductRestApiRepository productRestApiRepo;


    @Override
    public Product findOne(Long idProd) {
        Product prod = productRestApiRepo.findById(idProd).orElse(null);

        if (prod == null) throw new ProductException(ApiConstants.productNotFound);
        return prod;
    }

    @Override
    public Product save(Product p) {
        Product prod=productRestApiRepo.save(p);
        return prod;
    }

    @Override
    public List<Product> findProduct(String motCle) {

        return productRestApiRepo.findProduct(motCle);
    }

    @Override
    public Product update(Product p) {
        Product pd=productRestApiRepo.findById(p.getId()).orElse(null);
        Product product=productRestApiRepo.save(pd);
        return product;
    }

    @Override
    public void delete(Product idProduct) {
        productRestApiRepo.delete(idProduct);

    }


    @Override
    public List<Product> findAll() {
        return productRestApiRepo.findAll();
    }


}


