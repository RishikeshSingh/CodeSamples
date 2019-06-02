package Struct;

import java.util.Stack;

public class StackStructure {
    public static void main(String[] args) {
        /*int arr[] = {3,2,5,6,1,4,5};
        System.out.println(tapWater(arr));
        System.out.println(maxAreaRectangle(arr));*/
        /*String sample = "careermonk";
        int len = sample.length();
        System.out.println(adjacentDuplicates(sample, len, 0));*/
        //System.out.println(infixToPostfix("((A+B)-C*(D/E))+F"));
        System.out.println(nextGreatestCharacter("abcdqjkt"));
    }

    static int tapWater(int[] arr){
        int len = arr.length;
        int leftMax[] = new int[len];
        int rightMax[] = new int[len];
        int waterContent = 0;

        leftMax[0] = 0;
        rightMax[len-1] = len-1;
        for(int i=1;i<len;i++){
            if(arr[leftMax[i-1]]>arr[i]){
                leftMax[i] = leftMax[i-1];
            }else{
                leftMax[i] = i;
            }
        }
        for(int i=len-2;i>=0;i--){
            if(arr[rightMax[i+1]]>arr[i]){
                rightMax[i] = rightMax[i+1];
            }else{
                rightMax[i] = i;
            }
        }


        for(int i=0;i<len;i++){
            waterContent += Math.min(arr[leftMax[i]],arr[rightMax[i]]) - arr[i];
        }

        return waterContent;
    }

    static int maxAreaRectangle(int[] arr){
        int len = arr.length;
        Stack<Integer> buffer = new Stack<>();
        int leftMin[] = new int[len];
        int rightMin[] = new int[len];

        leftMin[0] = -1;
        rightMin[len-1] = len;

        buffer.push(0);
        for(int i=1;i<len;i++){
            if(arr[i]>=arr[buffer.peek()]){
                leftMin[i] = buffer.peek();
                buffer.push(i);
            }else{
                while (!buffer.isEmpty() && arr[i]>arr[buffer.peek()]){
                    buffer.pop();
                }
                if(buffer.isEmpty()){
                    leftMin[i] = -1;
                    buffer.push(i);
                }else{
                    leftMin[i] = buffer.peek();
                    buffer.push(i);
                }
            }
        }

        while(!buffer.isEmpty()){
            buffer.pop();
        }

        buffer.push(len-1);
        for(int i=len-2;i>=0;i--){
            if(arr[i]>arr[buffer.peek()]){
                rightMin[i] = buffer.peek();
                buffer.push(i);
            }else{
                while(!buffer.isEmpty() && arr[buffer.peek()]>arr[i]){
                    buffer.pop();
                }
                if(buffer.isEmpty()){
                    rightMin[i] = len;
                    buffer.push(i);
                }else{
                    rightMin[i] = buffer.peek();
                    buffer.push(i);
                }
            }
        }

        int maxArea = 0;
        int currentArea = 0;
        for(int i=0;i<len;i++){
            currentArea = (rightMin[i]-leftMin[i]-1)*arr[i];
            if(currentArea > maxArea){
                maxArea = currentArea;
            }
        }

        return maxArea;
    }

    static String adjacentDuplicates(String str, int len, int pos){
        if(pos == len){
            return "";
        }

        String tempStr = adjacentDuplicates(str, len, pos+1);
        if(tempStr.length() == 0){
            return str.charAt(pos)+"";
        }else{
            if(tempStr.charAt(0) == str.charAt(pos)){
                if(tempStr.length() > 1){
                    return tempStr.substring(1);
                }else{
                    return "";
                }
            }else{
                return str.charAt(pos)+tempStr;
            }
        }

    }

    static int operatorPreference(Character ch){
        if(ch == '^'){
            return 3;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }

        return 0;
    }

    static String infixToPostfix(String str){
        Stack<Character> operators = new Stack<>();
        String postfix = "";
        for(int i=0;i<str.length();i++){
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')){
                postfix += str.charAt(i);
            }else if(str.charAt(i) == '('){
                operators.push(str.charAt(i));
            }else if(str.charAt(i) == ')'){
                while (!operators.isEmpty() && operators.peek() != '('){
                    postfix += operators.pop();
                }
                operators.pop();
            }else{
                while(!operators.isEmpty() && operatorPreference(str.charAt(i))<operatorPreference(operators.peek())){
                    postfix += operators.pop();
                }
                operators.push(str.charAt(i));
            }
        }
        while(!operators.isEmpty()){
            postfix += operators.pop();
        }

        return postfix;
    }

    static void heapSort(int[] arr){
        int len = arr.length;

        for(int i=len/2-1; i>=0; i--){
            heapify(arr, i, len);
        }

        for(int i=len-1; i>=0; i--){
            System.out.println(arr[0]);
            arr[0] = arr[i];
            heapify(arr, i, 0);
        }
    }

    static String nextGreatestCharacter(String str){
        if(str.length() < 2){
            return "*";
        }
        int len = str.length();
        String answer = "";
        Stack<Character> previous = new Stack<>();
        for(int i=len-1;i>=0;i--){
            while(!previous.isEmpty() && previous.peek()<str.charAt(i)){
                previous.pop();
            }
            if(previous.isEmpty()){
                answer = '*'+ answer;
            }else{
                answer = previous.peek()+answer;
            }
            previous.push(str.charAt(i));
        }

        return answer;
    }

    static void heapify(int[] arr, int index, int len){
        int max = index;
        int left = 2*index+1;
        int right = 2*index+2;
        if(left<len && arr[max]<arr[left]){
            max = left;
        }
        if(right<len && arr[max]<arr[right]){
            max = right;
        }

        if(max != index){
            int buff = arr[index];
            arr[index] = arr[max];
            arr[max] = buff;
        }

        heapify(arr, max, len);
    }


}
