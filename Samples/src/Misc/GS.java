package Misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GS {

    public static void main(String[] args) {
        //System.out.println(firstMaximumLengthEvenWord("geeksforgeeks is a platform for geeks"));
        /*int arr[] = {9, 4, 20, 3, 10, 5};
        System.out.println(countOfSubArraysThatAddToAGivenSum(arr, 33));*/
        //System.out.println(characterCountString("aaabcdd"));
        /*int arr[][] = {{0,2,0,3,5},{0,1,1,1,0},{2,0,0,0,0}};
        System.out.println(collectMaxInArrayBottomLeftToTopRight(arr));*/
        //System.out.println(firstNonRepeatingCharacter("aaabbccdd"));
        //System.out.println(recurringSequenceInAFraction(50, 22));
        int arr[] = {4,5,6,5,4,3,2,3,2};
        findOptima(arr);
    }

    static String firstMaximumLengthEvenWord(String sentence){
        String array[] = sentence.split(" ");
        int max = 0;
        String maxString = "";
        for(int i=0;i<array.length;i++){
            if(array[i].length()%2 == 0 && array[i].length()>max){
                maxString = array[i];
                max = maxString.length();
            }
        }

        return maxString;
    }

    static int countOfSubArraysThatAddToAGivenSum(int[] arr, int sum){
        int len = arr.length;
        int memory[][] = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(i==j){
                    memory[i][j] = arr[i];
                }else{
                    memory[i][j] = memory[i][j-1]+arr[j];
                }
            }
        }

        int counter = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(memory[i][j] == sum){
                    counter++;
                }
            }
        }

        return counter;
    }

    static String characterCountString(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        if(str.length() == 1){
            return str.charAt(0)+"1";
        }
        char characters[] = str.toCharArray();
        int counter=1;
        String transformedString = "";
        for(int i=1;i<str.length();i++){
            if(characters[i-1] == characters[i]){
                counter++;
            }else{
                transformedString += characters[i-1]+""+counter;
                counter = 1;
            }
        }
        transformedString += characters[str.length()-1]+""+counter;
        return transformedString;
    }

    static int collectMaxInArrayBottomLeftToTopRight(int[][] matrix){
        return collectMaxUtil(matrix.length-1, 0, 0, matrix, 0, matrix[0].length-1);
    }

    static int collectMaxUtil(int row, int col, int count, int[][] matrix, int destRow, int destCol){
        if(row == destRow && col == destCol){
            return count+matrix[destRow][destCol];
        }

        int up = 0, right = 0;
        if(row-1>=0){
            up = collectMaxUtil(row-1,col,count+matrix[row][col], matrix, destRow, destCol);
        }
        if(col+1<=destCol){
            right = collectMaxUtil(row,col+1, count+matrix[row][col], matrix, destRow, destCol);
        }

        return Math.max(up, right);
    }

    static char firstNonRepeatingCharacter(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)+1);
            }else{
                map.put(curr, 1);
            }
        }

        char ans = '0';
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i)) == 1){
                ans = str.charAt(i);
                break;
            }
        }

        return ans;
    }

    static String recurringSequenceInAFraction(int num, int den){
        if(den==0){
            return "-1";
        }
        HashSet<Integer> set = new HashSet<>();
        String sequence = "";
        num = num%den*10;
        while(num%den!=0 && !set.contains(num%den)){
            set.add(num%den);
            sequence += num/den;
            num = num%den*10;
        }

        return sequence;
    }

    static List<Integer> findOptima(int[] arr){
        List<Integer> list = new LinkedList<>();
        findOptimaUtil(arr, 0, arr.length-1, list);
        for(int i: list){
            System.out.print(i+" ");
        }
        return list;
    }

    static void findOptimaUtil(int[] arr, int left, int right, List<Integer> list) {
        if(right-left>1){
            int mid = (right+left)/2;
            if((arr[mid] < arr[mid+1] && arr[mid] < arr[mid-1]) || (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])){
                list.add(mid);

            }

            if(!(Math.abs(arr[left]-arr[mid-1]) == mid-left)){
                findOptimaUtil(arr, left, mid, list);
            }
            if(!(Math.abs(arr[mid+1]-arr[right]) == mid+1-right)){
                findOptimaUtil(arr, mid, right, list);
            }
        }
    }
}
