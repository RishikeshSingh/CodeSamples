package DesignPatterns;

public class Test {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton k = null;

        {
            try {
                k = (Singleton) obj.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(obj.hashCode()+" "+k.hashCode());
    }


}
