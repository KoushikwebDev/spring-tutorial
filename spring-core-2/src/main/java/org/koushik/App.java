package org.koushik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // it creates container


        Dev devObj = context.getBean(Dev.class);

        devObj.doCode();
    }
}

// here manually creating the container by ApplicationContext and ClassPathXmlApplicationContext
// then spring.xml config to create the class automatically by the spring

//https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/xsd-configuration.html

// in the xml file create bean for the every object to be in the container

// but when you have to use the obj in different class, like Dev need Laptop, we can get it by setting ref in xml file.

// by the property we can set the value but for this we need the getter and setter method declared

// by the constructor-arg we need the construction in the class
