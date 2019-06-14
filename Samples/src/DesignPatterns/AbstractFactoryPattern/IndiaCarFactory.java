package DesignPatterns.AbstractFactoryPattern;

public class IndiaCarFactory {

    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case Micro:
                car = new MicroCar(Location.India);
                break;

            case Mini:
                car = new MiniCar(Location.India);
                break;

            case Luxury:
                car = new LuxuryCar(Location.India);
                break;

            default:
                break;

        }

        return car;
    }

}
