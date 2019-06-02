package Misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CCCalculatorGoogle {
    public static void main(String[] args) {
        System.out.println(calculate("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )"));
    }

    static int calculate(String equation){
        String expression[] = equation.split(" ");
        Stack<String> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        int sum = 0;
        int ptr=0;
        while(ptr < expression.length){
            if(expression[ptr].equals(")")){
                int num = Integer.parseInt(numbers.pop());
                String op = operators.pop();
                while(!numbers.peek().equals("(")){
                    num = operate(num, Integer.parseInt(numbers.pop()), op);
                }
                numbers.pop();
                numbers.push(""+num);
            }
            else if(expression[ptr].equals("+") || expression[ptr].equals("-") || expression[ptr].equals("*") || expression[ptr].equals("/")){
                operators.push(expression[ptr]);
            }else{
                numbers.push(expression[ptr]);
            }
            ptr++;
        }

        return Integer.parseInt(numbers.pop());
    }

    static int operate(int num1, int num2, String op){
        if(op.equals("*")){
            return num1*num2;
        }
        if(op.equals("/")){
            return num1/num2;
        }
        if(op.equals("+")){
            return num1+num2;
        }
        if(op.equals("-")){
            return num1-num2;
        }
        return -1;
    }

}
