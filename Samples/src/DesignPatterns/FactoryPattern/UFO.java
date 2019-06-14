package DesignPatterns.FactoryPattern;

public class UFO extends EnemyShip {

    public UFO(){
        name = "UFO"; //should have been setName("UFO")
        power = 20;
    }
}
