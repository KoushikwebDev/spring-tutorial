

package com.koushik.simpleWebApp.service;

import com.koushik.simpleWebApp.model.Product;
import com.koushik.simpleWebApp.repository.ProductRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//@Getter
@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }



    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product product){
        repo.save(product);
    }


    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
