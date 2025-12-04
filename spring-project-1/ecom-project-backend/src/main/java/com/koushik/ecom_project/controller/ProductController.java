package com.koushik.ecom_project.controller;


import com.koushik.ecom_project.model.Product;
import com.koushik.ecom_project.payload.APIResponse;
import com.koushik.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api") // it is for the default prefix of an API
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping({"", "/"}) // it is for the matching both / route
    public String greet(){
        return  "<h1>Hello World!</h1>";
    }

    @RequestMapping("/products")
    public ResponseEntity<APIResponse<List<Product>>> getAllProducts(){
//        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);

        List<Product> products = service.getAllProducts();

        APIResponse<List<Product>> response = new APIResponse<>(
                HttpStatus.OK.value(),
                "Products fetched successfully",
                products
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping("/product/{productId}")
    public ResponseEntity<Product> getProductDetails(@PathVariable int productId){
        Product product = service.getProductDetails(productId);

        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{

       Product response =  service.addProduct(product, imageFile);
       return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/product/{prodId}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int prodId){

       byte[] imageFile = service.getImage(prodId);

       return  ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageFile);
    }

    @PutMapping("/product/{prodId}")
    public ResponseEntity<String> updateProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile ,@PathVariable int prodId ) {

        Product response = null;
        try {
            response = service.updateProduct(product, prodId, imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(response != null){
            return  new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
           return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("product/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){

        service.deleteProduct(prodId);

        return new ResponseEntity<>("Product deleted", HttpStatus.OK);

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){

        List<Product> products = service.searchProduct(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}


// ResponseEntity to send the custom response with the status code

// To send custom response we have to create a structure object like APIResponse

//* custom response by the HashMap :
// @RequestMapping("/products")
//public ResponseEntity<Map<String, Object>> getAllProducts() {
//
//    Map<String, Object> response = new HashMap<>();
//    response.put("statusCode", HttpStatus.OK.value());
//    response.put("message", "Products fetched successfully");
//    response.put("data", service.getAllProducts());
//
//    return new ResponseEntity<>(response, HttpStatus.OK);
//}

