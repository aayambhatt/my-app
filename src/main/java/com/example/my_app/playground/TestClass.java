package com.example.my_app.playground;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {

    private final Car car;

    public TestClass(Car car){
        this.car = car;
    }

    @GetMapping("/test")
    public int test(){
        return this.car.start();
    }

}

@Component
class Car{
    private final Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public int start(){
        this.engine.start();
        System.out.println("Car started");
        return 1;
    }
}

@Component
class Engine{
    public void start(){
        System.out.println("Engine started");
    }
}
