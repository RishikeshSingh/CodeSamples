package Misc;

public class MatrixRotation {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16,}};
        //rotateMatrix(matrix);
        rotateMatrix(matrix);
    }

    static void rotateMatrix(int[][] matrix){
        int len = matrix.length;

        //display matrix
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<len/2;i++){
            for(int j=i;j<len-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = temp;
            }
        }

        System.out.println();
        //display matrix
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
