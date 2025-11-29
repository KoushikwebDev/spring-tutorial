package com.main.e_commerce;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // it is for the when computer has two object laptop and desktop, then dev's primary choice is the laptop, now we are deciding in this laptop level, it can be hanlde by the Dev obj level
public class Laptop implements Computer {

    public void compile(){
        System.out.println("compile done with laptop!");
    }
}
