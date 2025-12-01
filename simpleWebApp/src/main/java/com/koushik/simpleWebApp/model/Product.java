package com.koushik.simpleWebApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data // it will create getter and setter for this class, by the lombok
@AllArgsConstructor // it will create constructor for this class, by the lombok
public class Product {

    private int prodId;
    private String prodName;
    private int price;
}
