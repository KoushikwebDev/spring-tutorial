package com.main.e_commerce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // this means spring will create object, it will be available in bean
public class Dev {

    @Autowired  // field injection: it is connecting Dev to the Laptop(when only one object is available), so now we do not need to create object manually
    @Qualifier("desktop") // here we are deciding the which machine dev will use between laptop and desktop, but in the laptop class we have used the @Primary, now the @Qualifier will overwrite this

    private Computer comp; // this is the interface, so we can use any class that implements this interface

//*    Method 2 : by the constructor
//    public Dev(Laptop laptop){
//        this.laptop = laptop;
//    }

//*    Method 3 : by the setter method using autowired
//    @Autowired
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }

    public void doCode(){
        System.out.println("Build the project!");

        comp.compile();


    }
}
