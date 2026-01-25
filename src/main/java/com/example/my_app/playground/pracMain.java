package com.example.my_app.playground;

public class pracMain {
    public static void main(String[] args) {
        Container container = new Container();
        pracCar pracCar = container.getCar();
        pracCar.drive();
    }


}

class pracEngine{
    void start(){
        System.out.println("Engine started");
    }
}

class pracCar{
    private final pracEngine pracEngine;

    // constructor injection
    pracCar(pracEngine pracEngine){
        this.pracEngine = pracEngine;
    }

    void drive(){
        this.pracEngine.start();
        System.out.println("Car is driving");
    }
}

class Container{
    pracEngine getEngine(){
        return new pracEngine();
    }

    pracCar getCar(){
        return new pracCar(getEngine());
    }
}
