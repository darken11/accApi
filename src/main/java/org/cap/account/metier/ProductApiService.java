package org.cap.account.metier;

import org.cap.account.entities.Product;

import java.util.List;


public interface ProductApiService {

    List<Product> findAll();

    public Product findOne(Long idProduct);
    Product save(Product p);
    List<Product> findProduct(String motCle);
    Product update(Product p);
    void delete(Product idProduct);
}
