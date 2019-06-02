package GFG;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int arr1[] = {4,5,2,1,3};
        int arr2[] = {3,4,2,1,5};
        System.out.println(findSubsequence(arr1, arr2));
    }

    static int findSubsequence(int arr1[], int arr2[]){
        int memory[][] = new int[arr1.length+1][arr2.length+1];
        for(int i=0;i<=arr1.length;i++){
            for(int j=0;j<=arr2.length;j++){
                if(i==0 | j==0){
                    memory[i][j] = 0;
                }
                else if(arr1[i-1] == arr2[j-1]){
                    memory[i][j] = memory[i-1][j-1]+1;
                }else{
                    memory[i][j] = Math.max(memory[i-1][j], memory[i][j-1]);
                }
            }
        }

        return memory[arr1.length][arr2.length];
    }
}
