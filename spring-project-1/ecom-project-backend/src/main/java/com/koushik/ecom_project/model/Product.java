package com.koushik.ecom_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data // it will create all getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Entity // it will create the table, if exist h2 will update, for others have to set properties to update
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // it will set id Auto Increment and not null
    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date releaseDate;
    private boolean available;
    private int quantity;

    private String imageName;
    private String imageType;
    @Lob // LARGE OBJECT
    private byte[] imageData;


}

// JPA converts camelCase fields like releaseDate, imageName, imageType, imageData to snake_case column names (release_date, image_name, image_type, image_data) in the database by default.
