package DesignPatterns.FactoryPattern;

public class EnemyShipFactory {

    public EnemyShip makeEnemyShip(EnemyShipType enemyShipType){

        EnemyShip enemyShip = null;

        if(enemyShipType.equals(EnemyShipType.BigUFO)){
            return new BigUFO();
        }
        if(enemyShipType.equals(EnemyShipType.UFO)){
            return new UFO();
        }
        if(enemyShipType.equals(EnemyShipType.Rocket)){
            return new Rocket();
        }

        return enemyShip;
    }
}
