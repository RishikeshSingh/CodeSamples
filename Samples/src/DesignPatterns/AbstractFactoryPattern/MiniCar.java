package DesignPatterns.AbstractFactoryPattern;

public class MiniCar extends Car{
    public MiniCar(Location location){
        super(CarType.Luxury, location);
        construct();
    }

    @Override
    void construct() {
        System.out.println("connecting to Mini Car");
    }
}
