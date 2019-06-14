package DesignPatterns.FactoryPattern;

public abstract class EnemyShip {
    String name;
    int power;

    public String getName(){
        return name;
    }

    public void displayShip(){
        System.out.println(getName()+" has arrived");
    }
}
