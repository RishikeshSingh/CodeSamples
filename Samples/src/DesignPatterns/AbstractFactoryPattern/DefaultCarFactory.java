package DesignPatterns.AbstractFactoryPattern;

public class DefaultCarFactory {
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case Micro:
                car = new MicroCar(Location.Default);
                break;

            case Mini:
                car = new MiniCar(Location.Default);
                break;

            case Luxury:
                car = new LuxuryCar(Location.Default);
                break;

            default:
                break;

        }

        return car;
    }
}
