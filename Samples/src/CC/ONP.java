package CC;

import java.util.Scanner;
import java.util.Stack;

public class ONP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            String input = sc.next();
            System.out.println(convertString(input));
        }
    }

    static String convertString(String org){
        Stack<String> charList = new Stack();
        Stack<String> opList = new Stack();
        String bufferString = "";
        String finalString = "";
        for(int c=0; c<org.length(); c++){
            char temp = org.charAt(c);
            if((int)temp > 96 && (int)temp <= 122){
                charList.push(Character.toString(temp));
            }
            else if(temp == ')'){
                if(!opList.isEmpty()){
                    if(charList.empty()){
                        bufferString = opList.pop();
                    }else{
                        String rev = charList.pop();
                        if(charList.isEmpty()){
                            bufferString = rev+opList.pop();
                        }else{
                            bufferString = charList.pop()+rev+opList.pop();
                        }

                    }

                    if(charList.isEmpty()){
                        finalString += bufferString;
                    }else{
                        charList.push(bufferString);
                    }
                }
                bufferString = "";
            }else if(temp != '('){
                opList.push(Character.toString(temp));
            }
        }
        if(!charList.isEmpty()){
            String rev = charList.pop();
            bufferString = charList.pop()+rev+opList.pop();
            finalString += bufferString;
        }

        return finalString;
    }
}
