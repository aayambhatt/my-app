package com.example.my_app.learning_example;

import org.springframework.stereotype.Component;

@Component
public class CoffeeMaker {
    public void brew(){
        System.out.println("Coffee is ready");
    }

}
