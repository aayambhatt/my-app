package com.example.my_app.learning_example;

import org.springframework.stereotype.Component;

@Component
public class CoffeeShop {

    private final CoffeeMaker coffeeMaker;

    public CoffeeShop(CoffeeMaker coffeeMaker){
        this.coffeeMaker = coffeeMaker;
    }

    public void serveCoffee(){
        coffeeMaker.brew();

    }

}
