package GFG;

public class ExpressionTree {
    public static void main(String[] args) {
        String str = "- 4 7";
        System.out.println(expressionValue(str));
    }

    static int expressionValue(String str){
        String arr[] = str.split(" ");
        int startpoint = (arr.length-2)/2;
        while(startpoint>=0){
            int left = Integer.parseInt(arr[startpoint*2+1]);
            int right = Integer.parseInt(arr[startpoint*2+2]);
            arr[startpoint] = ""+calculate(arr[startpoint], left, right);
            startpoint--;
        }

        return Integer.parseInt(arr[0]);
    }

    static int calculate(String operator, int n, int m){
        if(operator.equals("+")){
            return n+m;
        }
        if(operator.equals("-")){
            return n-m;
        }
        if(operator.equals("*")){
            return n*m;
        }
        if(operator.equals("*")){
            return n*m;
        }

        return 0;
    }
}
