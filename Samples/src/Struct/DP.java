package Struct;

import java.util.LinkedList;
import java.util.List;

public class DP {
    public static void main(String[] args) {
        /*int wt[] = {1,5,4,3};
        int val[] = {1,7,5,4};
        System.out.println(knapSack(7, wt, val));*/
        /*int set[] = {1,7,5,2};
        int sum = 8;
        System.out.println(subsetSum(sum, set));*/
        /*String str1 = "abcdaf";
        String str2 = "acbcf";
        System.out.println(longestCommonSubsequence(str1, str2));*/
        /*int matleft[] = {2,3,6,4};
        int matright[] = {3,6,4,5};
        matrixChainMultiplication(matleft, matright);*/
        /*int coins[] = {1,5,6,8};
        int amount = 23;
        System.out.println(coinChange(coins, amount));*/
        /*int sequence[] = {3,4,-1,0,6,2,3};
        System.out.println(longestIncreasingSubsequence(sequence));*/
        /*String outcome = "march";
        String initial = "cart";
        System.out.println(minimumEditDistance(initial, outcome));*/
        //System.out.println(eggDrop(2,6));
        /*int prices[] = {3,5,8,9,10,17,17,20};
        System.out.println(cuttingRod(8, prices));*/
        int coins[] = {2,3,6,5};
        System.out.println(coinChangeCountWays(coins, 10));
    }

    //1hr 45 mins
    static int knapSack(int W, int[] weights, int[] values){
        int len = weights.length;
        int memory[][] = new int[len+1][W+1];
        for(int i=0;i<=len;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0){
                    memory[i][j] = 0;
                }else if(weights[i-1] <= j){
                    memory[i][j] = Math.max(values[i-1]+memory[i-1][j-weights[i-1]], memory[i-1][j]);
                }else{
                    memory[i][j] = memory[i-1][j];
                }
            }
        }

        for(int i=0;i<=len;i++){
            for(int j=0; j<=W;j++){
                System.out.print(memory[i][j]);
            }
            System.out.println();
        }

        //backtracking
        int i = len, j=W;
        System.out.println("list of weights");
        //List<Integer> listOfItems = new LinkedList<>();
        while (i>=1 && j>=1) {
            if (memory[i][j] != memory[i - 1][j]) {
                //listOfItems.add(weights[i - 1]);
                j -= weights[i-1];
                System.out.print(weights[i - 1] + " ");
            }
            i--;
        }
        System.out.println();

        return memory[len][W];

    }

    static int subsetSum(int sum, int[] set){
        int len = set.length;
        int memory[][] = new int[len+1][sum+1];
        memory[0][0] = 1;
        for(int i=1;i<=len;i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    memory[i][j] = 1;
                }else if(j<set[i-1]){
                    memory[i][j] = memory[i-1][j];
                }else{
                    if(memory[i-1][j] == 1 || memory[i-1][j-set[i-1]] == 1){
                        memory[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0;i<=len;i++){
            for(int j=0; j<=sum;j++){
                System.out.print(memory[i][j]);
            }
            System.out.println();
        }

        int i=len,j=sum;
        //backtracking
        while(i>=1 && j>=1){
            if(memory[i-1][j] != 1 && memory[i-1][j-set[i-1]] == 1){
                j = j-set[i-1];
                System.out.print(set[i-1]);
            }
            i--;
        }
        System.out.println();

        return memory[len][sum];
    }

    static int longestCommonSubsequence(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        char charSeq1[] = str1.toCharArray();
        char charSeq2[] = str2.toCharArray();

        int memory[][] = new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++){
            for(int j=0; j<=len2; j++){
                if(i==0 || j==0){
                    memory[i][j] = 0;
                }else if(charSeq1[i-1] == charSeq2[j-1]){
                    memory[i][j] = memory[i-1][j-1]+1;
                }else{
                    memory[i][j] = Math.max(memory[i-1][j], memory[i][j-1]);
                }

            }
        }

        int i=len1, j=len2;
        while(i>=1 && i>=1){
            if(memory[i-1][j] == memory[i][j-1] && memory[i-1][j-1]+1 == memory[i][j]){
                System.out.print(charSeq1[i-1]);
                i--;j--;
            }else if(memory[i-1][j] > memory[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println();

        return memory[len1][len2];
    }

    static int matrixChainMultiplication(int[] m, int[] n){
        int len = m.length;
        int memory[][] = new int[len][len];
        int backtrack[][] = new int[len][len];

        for(int i=0;i<len;i++){
            int row = 0;
            int col = i;
            while (col<len){
                if(row == col){
                    memory[row][col] = 0;
                }else{
                    memory[row][col] = Math.min(memory[row+1][col]+(m[row+1]*n[col]*m[row]), memory[row][col-1]+(m[row]*n[col-1]*n[col]));
                    if(memory[row+1][col]+(m[row+1]*n[col]*m[row]) > memory[row][col-1]+(m[row]*n[col-1]*n[col])){
                        memory[row][col] = memory[row][col-1]+(m[row]*n[col-1]*n[col]);
                        //backtrack[row][col] =
                    }
                }
                row++;
                col++;
            }
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(memory[i][j]);
            }
            System.out.println();
        }

        return memory[len-1][len-1];
    }

    static int coinChange(int[] coins, int amount){
        int len = coins.length;
        int memory[][] = new int[len+1][amount+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    memory[i][j] = memory[i-1][j];
                }else{
                    if(i>1){
                        memory[i][j] = Math.min(j/coins[i-1] + memory[i-1][j%coins[i-1]], memory[i-1][j]);
                    }else{
                        memory[i][j] = j/coins[i-1] + memory[i-1][j%coins[i-1]];
                    }
                }
            }
        }

        int row=len,col=amount;
        while (row>=1 && col>=1){
            if(memory[row][col] < memory[row-1][col]){
                System.out.print("["+coins[row-1]+":"+col/coins[row-1]+"] ");
                col = col%coins[row-1];
            }
            row--;
        }

        return memory[len][amount];
    }

    static int longestIncreasingSubsequence(int[] arr){
        int len = arr.length;
        int memory[] = new int[len];
        for(int i=0;i<len;i++){
            memory[i] = 1;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    memory[i] = Math.max(memory[i],memory[j]+1);
                }
            }
        }
        return memory[len-1];
    }

    static int minimumEditDistance(String str1, String str2){
        int len1 = str2.length();
        int len2 = str1.length();
        char seq1[] = str2.toCharArray();
        char seq2[] = str1.toCharArray();
        int memory[][] = new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0){
                    memory[i][j] = i;
                }else if(j==0){
                    memory[i][j] = j;
                }else if(seq1[i-1] == seq2[j-1]){
                    memory[i][j] = memory[i-1][j-1];
                }else{
                    memory[i][j] = 1 + Math.min(memory[i-1][j-1], Math.min(memory[i-1][j], memory[i][j-1]));
                }
            }
        }

        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                System.out.print(memory[i][j]+" ");
            }
            System.out.println();
        }

        return memory[len1][len2];

    }

    static int eggDrop(int eggs, int floors){
        int memory[][] = new int[eggs+1][floors+1];
        for(int i=1;i<=floors;i++){
            memory[1][i] = i;
        }

        for(int i=2;i<=eggs;i++){
            for(int j=1;j<=floors;j++){
                if(j<i){
                    memory[i][j] = memory[i-1][j];
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k=1;k<=j;k++){
                        if(min > Math.max(memory[i-1][k-1], memory[i][j-k])){
                            min = Math.max(memory[i-1][k-1], memory[i][j-k]);
                        }
                    }
                    memory[i][j] = min+1;
                }
            }

        }

        for(int i=0;i<=eggs;i++){
            for(int j=0;j<=floors;j++){
                System.out.print(memory[i][j]+" ");
            }
            System.out.println();
        }

        return memory[eggs][floors];

    }

    static int cuttingRod(int length, int prices[]){
        int memory[][] = new int[length+1][length+1];
        for(int i=0;i<=length;i++){
            memory[i][0] = 0;
        }
        for(int i=1;i<=length;i++){
            for(int j=1;j<=length;j++){
                if(i==1){
                    memory[i][j] = j*prices[i-1];
                }else if(i<=j){
                    memory[i][j] = Math.max(prices[i-1]+memory[i][j-i], memory[i-1][j]);
                }else{
                    memory[i][j] = memory[i-1][j];
                }
            }
        }

        return memory[length][length];
    }

    static int coinChangeCountWays(int coins[], int amount){
        int memory[][] = new int[coins.length+1][amount+1];

        for(int i=1;i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j==0){
                    memory[i][j] = 1;
                }else if(coins[i-1]>j){
                    memory[i][j] = memory[i-1][j];
                }else{
                    memory[i][j] = memory[i][j-coins[i-1]]+memory[i-1][j];
                }
            }
        }

        return memory[coins.length][amount];
    }

}

