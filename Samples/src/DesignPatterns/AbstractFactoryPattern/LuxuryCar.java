package DesignPatterns.AbstractFactoryPattern;

public class LuxuryCar extends Car{

    public LuxuryCar(Location location){
        super(CarType.Luxury, location);
        construct();
    }

    @Override
    void construct() {
        System.out.println("connecting to Luxury Car");
    }
}
