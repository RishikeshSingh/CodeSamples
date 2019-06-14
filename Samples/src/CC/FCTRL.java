package CC;

import java.util.Scanner;

public class FCTRL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int arr[] = new int[t];
        for(int i=0;i<t;i++){
            arr[i] = sc.nextInt();
        }
        for(int j=0;j<t;j++){
            int counter=0;
            int divisor=5;
            while(divisor <= arr[j]){
                counter+=arr[j]/divisor;
                divisor*=5;
            }
            System.out.println(counter);
        }
    }
}
