package com.koushik.simpleWebApp.controllers;

import com.koushik.simpleWebApp.model.Product;
import com.koushik.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @RequestMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        System.out.println(product);
        service.addProduct(product);

        return "Product Added Successfully";
    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody  Product product){
        service.updateProduct(product);
        return "Product Updated Successfully";
    }

    @DeleteMapping("/products/{prodId}")
    public String deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);

        return "Product Deleted Successfully";
    }
}
