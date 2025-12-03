package com.koushik.simpleWebApp.repository;


import com.koushik.simpleWebApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository; // Extends JpaRepository to provide CRUD operations for Product entity
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a Spring Data Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {


}
