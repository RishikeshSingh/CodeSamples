package CC;

import java.util.Arrays;
import java.util.Scanner;

public class COOLING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int num = sc.nextInt();
            if(num%2==0){
                System.out.println(num);
            }else{
                System.out.println(num/2+1);
            }
            t--;
        }
     }
}
