package com.koushik.simpleWebApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it will create getter and setter for this class, by the lombok
@AllArgsConstructor // it will create constructor for this class, by the lombok
@NoArgsConstructor // This will create a default constructor for JPA
@Entity // to make this class as entity for JPA => table creation
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private int price;
}


// JPA => Java Persistence API => to interact with the database in an OOP way