package DesignPatterns.AbstractFactoryPattern;

import java.time.LocalDate;

public abstract class Car {

    CarType carType;
    Location location;

    Car(CarType carType, Location location){
        this.carType = carType;
        this.location = location;
    }

    abstract void construct();
}
