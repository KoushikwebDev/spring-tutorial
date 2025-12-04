package com.koushik.ecom_project.service;


import com.koushik.ecom_project.model.Product;
import com.koushik.ecom_project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service // now it is available in the bean
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }


    public Product getProductDetails(int productId) {
        return repo.findById(productId).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return  repo.save(product);

    }

    public byte[] getImage(int prodId) {
        Product product = repo.findById(prodId).orElse(null);

        assert product != null;
        return product.getImageData();

    }

    public Product updateProduct(Product product, int prodId, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return  repo.save(product);

    }

    public void deleteProduct(int prodId) {

        repo.deleteById(prodId);
    }

    public List<Product> searchProduct(String keyword) {


       return repo.searchProduct(keyword);
    }
}
