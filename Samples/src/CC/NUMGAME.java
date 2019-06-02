package CC;

import java.util.Scanner;

public class NUMGAME {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int num = sc.nextInt();
            if(num%2==0){
                System.out.println("ALICE");
            }else{
                System.out.println("BOB");
            }

            t--;
        }
    }
}
