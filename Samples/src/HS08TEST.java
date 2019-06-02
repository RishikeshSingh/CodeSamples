import java.util.Scanner;

public class HS08TEST {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //double a = sc.nextDouble();
        //double b = sc.nextDouble();

        double a = 30;
        double b = 120.00;
        System.out.println(util(a,b));
        System.out.println(89.5 == 89.50);
    }

    static double util(double cash, double bal){
        if(cash%5==0 && cash<bal){
            return bal-cash-new Double(0.50);
        }
        return bal;
    }
}
