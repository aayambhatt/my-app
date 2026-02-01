package com.example.my_app.playground;

import org.springframework.stereotype.Component;


@Component
class pracEngine{
    void start(){
        System.out.println("Engine started");
    }
}

@Component
class pracCar{
    private final pracEngine pracEngine;

    // constructor injection
    pracCar(pracEngine pracEngine){
    this.pracEngine = pracEngine;
    }

    void drive(){
        pracEngine.start();
        System.out.println("Car is driving");
    }
}

//class Container{
//    pracEngine getEngine(){
//        return new pracEngine();
//    }
//
//    pracCar getCar(){
//        return new pracCar(getEngine());
//    }
//}
