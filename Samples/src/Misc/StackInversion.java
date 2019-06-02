package Misc;

import java.util.Stack;

public class StackInversion {
    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        int arr[] = {2,3,5,6};
        for(int i=0; i<arr.length; i++){
            stack.push(arr[i]);
        }
        reverseStack(stack);
        for(int i=0; i<arr.length; i++){
            System.out.println(stack.pop());
        }
    }

    static Stack<Integer> reverseStack(Stack<Integer> stack){
        int len = stack.size();
        int arr[] = new int[len];
        reverseStackUtil(stack, arr, len, 0);

        return stack;
    }

    static void reverseStackUtil(Stack<Integer> stack, int[] arr, int len, int index){
        if(len == 0){
            return;
        }
        arr[index] = stack.pop();
        len--;index++;
        reverseStackUtil(stack, arr, len, index);
        stack.push(arr[len]);
    }

}
