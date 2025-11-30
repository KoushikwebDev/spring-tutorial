package com.koushik.simpleWebApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // its return the data
// @Controller // its return the web page
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "<h1>Hello Java Web App</>";
    }

    @RequestMapping("/about")
    public String about(){
        return "hello about";
    }
}
