package DesignPatterns.AbstractFactoryPattern;

public class AbstractDesign {

    //flexibility of deciding car type at run time with factory pattern
    //flexibility of deciding which factory to use to create different classes
    public static void main(String[] args)
    {
        System.out.println(CarFactory.buildCar(CarType.Micro));
        System.out.println(CarFactory.buildCar(CarType.Mini));
        System.out.println(CarFactory.buildCar(CarType.Luxury));
    }
}
