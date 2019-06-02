package CC;

import java.util.Scanner;

public class SUMTRIAN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            int rows = sc.nextInt();
            int maxsum = 0;
            int arr[][] = new int[rows][rows];
            for(int r=0;r<rows;r++) {
                for (int c = 0; c <= r; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
            //System.out.println(findMax(rows-1, arr, maxsum, 0,0));
            makeSumTriangle(rows, arr);
        }
    }
    static int findMax(int rows, int arr[][], int sum, int i, int j){
        if(i>rows){
            return sum;
        }
        return Math.max(findMax(rows, arr, sum+arr[i][j], i+1, j),findMax(rows, arr, sum+arr[i][j], i+1, j+1));
    }

    static void makeSumTriangle(int rows, int arr[][]){
        for(int i=1;i<rows;i++){
            arr[i][0] = arr[i][0]+arr[i-1][0];
            for(int j=1;j<=i;j++){
                arr[i][j] += Math.max(arr[i-1][j], arr[i-1][j-1]);
            }
        }
        int max =0;
        for(int i=0;i<rows;i++){
            if(arr[rows-1][i]>max){
                max = arr[rows-1][i];
            }
        }
        System.out.println(max);
    }
}
