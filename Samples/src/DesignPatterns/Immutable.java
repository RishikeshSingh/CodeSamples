package DesignPatterns;

//make class final so that child classes cannot be created
/*
final keyword:
makes variable constant
prevents method overriding
prevents inheritance
 */
public final class Immutable {
    //set all variables as final
    private final String str;
    private final int regNo;

    //a parameterized constructor
    public Immutable(String str, int regNo){
        this.str = str;
        this.regNo = regNo;
    }

    //no setters only getters

    public String getStr() {
        return str;
    }

    public int getRegNo() {
        return regNo;
    }
}
