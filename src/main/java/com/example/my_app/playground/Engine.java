//package com.example.my_app.playground;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///*
//IoC: You don't create and manage your dependencies, the framework does it for you
// */
//public class Engine {
//
//    void start(){
//        System.out.println("Engine started");
//    }
//}
//
//@Component
//class Car{
//    private  Engine engine;
//
////     Constructor injection - most preferred
//    public Car(Engine engine) {
//        this.engine = engine;
//    }
//
////    // Setter injection
////    public void setEngine(Engine engine){
////        this.engine = engine;
////
////    }
//
//
//
//    public void drive(){
//        this.engine.start();
//        System.out.println("Car is moving");
//    }
//}
//
//
//class Demo{
//    @Autowired
//    private Car car;
//
//    @Autowired
//    public Demo(Car car){
//        this.car = car;
//    }
//
//    public void testFunc(){
//        this.car.drive();
//    }
//
//}
