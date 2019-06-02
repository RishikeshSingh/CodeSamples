import java.util.Scanner;

public class CIELAB {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int diff = a-b;
        if(diff%10>0){
            diff--;
        }else{
            diff++;
        }

        System.out.println(diff);
    }
}
