package com.example.my_app.learning_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CoffeeMaker coffeeMaker(){
        return new CoffeeMaker(); // spring will manage this object
    }
}
