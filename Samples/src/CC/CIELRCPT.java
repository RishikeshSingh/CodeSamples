package CC;

import java.util.Scanner;

public class CIELRCPT {
    public static void main(String[] args) {
        //System.out.println(convertToBinaryString(10));
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i=0;i<test;i++){
            int num = sc.nextInt();
            System.out.println(menus(num));
        }
    }

    static int menus(int p){
        int counter = 0;
        if(p > 2048){
            counter = p/2048;
            p = p%2048;
        }
        String binary = Integer.toBinaryString(p);
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i) == '1'){
                counter++;
            }
        }
        return counter;
    }

    static String convertToBinaryString(int p){
        StringBuffer binary = new StringBuffer("");
        while(p>0){
            if(p%2==1){
                binary.append("1");
            }else{
                binary.append("0");
            }
            p = p/2;
        }

        return binary.reverse().toString();
    }
}
