package CC;

import java.util.Scanner;

public class PERMUT2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int inp = sc.nextInt();
            if(inp == 0){
                break;
            }else{
                int permutation[] = new int[inp];
                for(int i=0; i<inp; i++){
                    permutation[i] = sc.nextInt();
                }
                if(isAmbi(inp, permutation)){
                    System.out.println("ambiguous");
                }else{
                    System.out.println("not ambiguous");
                }
            }

        }
    }

    static boolean isAmbi(int len, int[] arr){
        boolean ambiguous = true;
        for(int i=0; i<len; i++){
            int ithnum = arr[i];
            if(ithnum > len || arr[ithnum-1] != i+1){
                ambiguous = false;
                break;
            }
        }

        return ambiguous;
    }
}
