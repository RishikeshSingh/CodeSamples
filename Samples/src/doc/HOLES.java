package doc;

import java.util.Scanner;

public class HOLES {
    public static void main(String[] args){
        int holeIndex[] = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String input[] = new String[t];
        for(int j=0;j<t;j++){
            input[j] = sc.nextLine().toUpperCase();
        }
        for(int j=0;j<t;j++){
            int holes = 0;
            for (int i=0;i<input[j].length();i++){
                holes+= holeIndex[input[j].charAt(i)-'A'];
            }
            System.out.println(holes);
        }


    }
}
