package DesignPatterns.AbstractFactoryPattern;

public class MicroCar extends Car{
    public MicroCar(Location location){
        super(CarType.Micro, location);
        construct();
    }

    @Override
    void construct() {
        System.out.println("connecting to Micro Car");
    }
}
