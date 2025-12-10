package com.koushik.ecom_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomProjectApplication.class, args);
	}

}

//* @SpringBootApplication it handles @Configuration, @EnableAutoConfiguration, @ComponentScan
// AutoConfiguration like db connection and other things
// ComponentScan like to create bin from a class and manage its life cycle
// Configuration to define extra beans or custom beans if needed
