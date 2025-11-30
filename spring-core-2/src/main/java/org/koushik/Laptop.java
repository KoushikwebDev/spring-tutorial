package org.koushik;

public class Laptop implements Computer {

    public Laptop(){
        System.out.println("Laptop constructor");
    }

    public void compile(){
        System.out.println("Compile done with the laptop");
    }
}
