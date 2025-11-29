package com.main.e_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {

//        here creating context of the container
	ApplicationContext context =  SpringApplication.run(ECommerceApplication.class, args); // this creates container of objects

        Dev obj = context.getBean(Dev.class);
        obj.doCode();
	}

}

// ./mvnw spring-boot:run => to run the application or ./mvnw spring-boot:run

// ./gradlew bootRun


