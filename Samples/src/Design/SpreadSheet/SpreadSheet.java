package Design.SpreadSheet;

import java.util.HashSet;
import java.util.Scanner;

//not calculating values of the cell which might fall in loop
/*
* assumptions
* each cell either has a number or an expression with two cell values and some operator separated by spaces
* each cell values' (which would be a string) first character is a capital alphabet suggesting row and the next characters would form a
* number suggesting the column number eg: A456 + B272 => (A:456)(operator)(B:272)
* */
public class SpreadSheet {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        //test cases :
        //String sheet[][] = {{"23", "B1 * B2"}, {"A1 * C2", "24 * A1"}, {"45", "2"}}; //loop not present
        String sheet[][] = {{"23", "B1 * B2"}, {"A1 * C2", "24 * A1"}, {"45", "B1 + 2"}}; //loop present

        /////////////////////////////////////// printing initial spreadsheet
        for(int i=0;i<=2;i++){
            for(int j=0;j<2;j++){
                System.out.print(sheet[i][j]+" ");
            }
            System.out.println();
        }

        //with assumed 3*2 size spreadsheet
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 2; j++) {
                char initial = 'A';
                initial+=i;
                HashSet<String> visited = new HashSet<>();
                calculateCellValue(sheet, ""+initial+j, visited);
            }
        }

        ///////////////////////////////////the actual program
        /*int rows = sc.nextInt();
        int cols = sc.nextInt();
        String sheet[][] = createSheet(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= cols; j++) {
                char initial = 'A';
                initial+=i;
                HashSet<String> visited = new HashSet<>();
                calculateCellValue(sheet, ""+initial+j, visited);
            }
        }*/
        ///////////////////////////////////


        ////////////////////////////// printing final spreadsheet
        System.out.println("/////////////////////////////");

        for(int i=0;i<=2;i++){
            for(int j=0;j<2;j++){
                System.out.print(sheet[i][j]+" ");
            }
            System.out.println();
        }


    }

    static String[][] createSheet(int n, int m){
        Scanner sc = new Scanner(System.in);
        String sheet[][] = new String[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sheet[i][j] = sc.next();
            }
        }
        return sheet;
    }

    static boolean isExp(String str){
        return !str.matches("-?\\d+");
    }

    static int calculate(int num1, int num2, String operator){
        if(operator.equals("+")){
            return num1+num2;
        }else if(operator.equals("-")){
            return num1-num2;
        }else if(operator.equals("*")){
            return num1*num2;
        }else if(operator.equals("/")){
            return num1/num2;
        }

        return -1;
    }

    static void calculateCellValue(String[][] sheet, String cell, HashSet<String> visited){
        //checks if there is a loop condition
        if (visited.contains(cell)) {
            return;
        }else{
            visited.add(cell);
        }

        int row  = cell.charAt(0)-'A';
        int col = Integer.parseInt(cell.substring(1,cell.length()))-1;

        //checking if any cell doesn't point to any place outside sheet
        if(row>sheet.length || col>sheet[0].length){
            return;
        }

        if(isExp(sheet[row][col])){
            String exp[] = sheet[row][col].split(" ");
            String leftCellValue, rightCellValue;
            int left, right;

            //for operand 1
            if(isExp(exp[0])){
                calculateCellValue(sheet, exp[0], visited);
                leftCellValue = sheet[exp[0].charAt(0)-'A'][Integer.parseInt(exp[0].substring(1,cell.length()))-1];
                //if loop condition has occured that means the cell value isn't calculated and will throw number format expression or goes outside sheet
                if(isExp(leftCellValue)){
                    return;
                }
                left = Integer.parseInt(leftCellValue);
            }else{
                left = Integer.parseInt(exp[0]);
            }

            //for operand 2
            if(isExp(exp[2])){
                calculateCellValue(sheet, exp[2], visited);
                rightCellValue = sheet[exp[2].charAt(0)-'A'][Integer.parseInt(exp[2].substring(1,cell.length()))-1];
                if(isExp(rightCellValue)){
                    return;
                }
                right = Integer.parseInt(rightCellValue);
            }else{
                right = Integer.parseInt(exp[2]);
            }


            //storing the expression value in string format
            sheet[row][col] = ""+calculate(left, right, exp[1]);
        }

    }
}
