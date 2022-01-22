package org.cap.account;


import org.cap.account.entities.Category;
import org.cap.account.entities.Product;
import org.cap.account.repository.CategoryRestApiRepository;
import org.cap.account.repository.ProductRestApiRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        ApplicationContext ctx=  SpringApplication.run(ProductApplication.class, args);
        CategoryRestApiRepository categoryRestApiRepository=ctx.getBean(CategoryRestApiRepository.class);
       /* Category category=categoryRestApiRepository.save(new Category("PC"));
        Category category1=categoryRestApiRepository.save(new Category("Scanner"));
        Category category2=categoryRestApiRepository.save(new Category("Phone"));


        ProductRestApiRepository productRestApi=ctx.getBean(ProductRestApiRepository.class);
        productRestApi.save(new Product("LapTop",1000,2,category));
        productRestApi.save(new Product("Scanner",800,7,category1));
        productRestApi.save(new Product("Flash",200,3,category1));
        productRestApi.save(new Product("SmartPhone",200,10,category2));

        Product product=productRestApi.findProduct("LapTop");
        System.out.println(product.getDesignation());
        System.out.println("#############################");
        Product p=productRestApi.findById(2L).orElse(null);
        System.out.println(p.getDesignation());
        System.out.println("#############################");
        List<Product> prods=productRestApi.findAll();
        for(Product pr:prods){
            System.out.println(pr.getDesignation()+">>"+pr.getPrice());



        }*/
    }

}
