package com.koushik.simpleWebApp.service;

import com.koushik.simpleWebApp.model.Product;
import com.koushik.simpleWebApp.repository.ProductRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@Getter
@Service
public class ProductService2 {

    @Autowired
    ProductRepo repo;

    public List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"New Product", 1099),
            new Product(2,"New Product 2", 1088)
    ));

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

    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product product){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProdId() == product.getProdId()){
                products.set(i, product);
                return;
            }
        }
    }


    public void deleteProduct(int prodId) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProdId() == prodId){
                products.remove(i);
                return;
            }
        }
    }
}

