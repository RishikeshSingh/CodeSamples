package DesignPatterns;

public class Singleton implements Cloneable{

    //private staic instance of the class
    private static Singleton instance;
    String name = "blah";

    //private constructor restricted to its class itself
    private Singleton(){}

    //'static' method to fetch the instance of the class
    //synchronized to prevent creation of two objects if parallel request for creating the object comes
    synchronized public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }

    public Object clone() throws CloneNotSupportedException {
        //return super.clone();
        throw new CloneNotSupportedException();
    }
}
