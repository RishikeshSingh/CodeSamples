package DesignPatterns.FactoryPattern;

import java.util.Random;
import java.util.Scanner;


/*
* When you don't know ahead of time what class object you need
* when all potential class are in same subclass hierarchy
* */
public class TestingPattern {
    public static void main(String[] args) {

        Random rand = new Random();
        EnemyShipFactory factory = new EnemyShipFactory();

        int n = 10;
        while (n>0){
            int num = rand.nextInt(3);
            System.out.println("random no. generated : "+ num);
            EnemyShip enemyShip = factory.makeEnemyShip(TestingPattern.getShipType(num));
            enemyShip.displayShip();
            n--;
        }

    }

    static EnemyShipType getShipType(int num){
        if(num == 0){
            return EnemyShipType.Rocket;
        }else if(num == 1){
            return EnemyShipType.UFO;
        }

        return EnemyShipType.BigUFO;
    }
}
