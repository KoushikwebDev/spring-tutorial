package com.koushik.simpleWebApp.service;

import com.koushik.simpleWebApp.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


//@Getter
@Service
public class ProductService {

    public List<Product> products = Arrays.asList(
            new Product(1,"New Product", 1099),
            new Product(2,"New Product 2", 1088)
    );

    public List<Product> getProducts(){
    return products;
    }

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(null);
    }


//    public Product getProductById(int prodId) {
//        for(Product p : products) {
//            if(p.getProdId() == prodId) {
//                return p;
//            }
//        }
//        return null; // not found
//    }



}
