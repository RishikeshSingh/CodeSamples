package LC;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
    }
    public static int reverse(int x) {
        String num = x+"";
        String reverse = "";
        boolean flag = false;
        String int_max = Integer.MAX_VALUE+"";

        if(num.charAt(0) == '-'){
            num = num.substring(1);
            flag = true;
        }

        for(int i=num.length()-1;i>=0;i--){
            reverse += num.charAt(i);
        }

        if(num.length()>9 && reverse.compareTo(int_max)>0){
            return 0;
        }

        int ans = Integer.parseInt(reverse);
        if(flag){
            ans = 0-ans;
        }

        return ans;
    }
}
