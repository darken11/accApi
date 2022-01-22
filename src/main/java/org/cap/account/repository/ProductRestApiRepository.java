package org.cap.account.repository;

import org.cap.account.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRestApiRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.designation like %:x%")
    public List<Product> findProduct(@Param("x")String mc);

}
