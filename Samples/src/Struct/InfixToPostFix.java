package Struct;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        //System.out.println(infixToPostfix("(A-B/C)*(A/K-L)"));
        System.out.println(infixToPostfix("((a+b)-(c*(d/e))+f"));
        System.out.println(postfixToInfix("ab*c+"));
    }


    static String infixToPostfix(String str){
        Stack<String> exp = new Stack<>();
        Stack<String> op = new Stack<>();
        String elements[] = str.split("");
        for(int i=0;i<str.length();i++){

            if(elements[i].equals(")")){
                String temp = "";
                while(!exp.peek().equals("(")){
                    temp = exp.pop()+temp;
                }
                exp.pop();
                temp = temp+op.pop();
                exp.push(temp);
            }else if(elements[i].equals("+") || elements[i].equals("-")){
                op.push(elements[i]);
            }else{
                exp.push(elements[i]);
            }
        }

        String postfix = exp.pop();
        while(!op.empty()){
            postfix += op.pop();
        }

        return postfix;
    }

    static String postfixToInfix(String str){
        Stack<String> exp  = new Stack<>();
        String elements[] = str.split("");
        for(int i=0;i<str.length();i++){
            String temp = "";
            if(elements[i].equals("+") || elements[i].equals("-") || elements[i].equals("*") || elements[i].equals("/")){
                String buff = exp.pop();
                temp = "("+exp.pop()+elements[i]+buff+")";
                exp.push(temp);
            }else{
                exp.push(elements[i]);
            }
        }
        return exp.pop();
    }
}


