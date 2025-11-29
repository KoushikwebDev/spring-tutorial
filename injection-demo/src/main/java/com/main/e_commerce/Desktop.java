package com.main.e_commerce;


import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {

    public void compile(){
        System.out.println("compile done with desktop!");
    }
}
