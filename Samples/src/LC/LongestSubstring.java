package LC;

import java.util.HashMap;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abckbekdc"));
    }

    public static int longestSubstring(String str){
        if(str.length() == 0){
            return 0;
        }
        int left=0, right=0;
        HashMap<Character, Integer> map = new HashMap();
        int maxLength = 0;
        while(right<str.length()){
            char curr = str.charAt(right);
            if(map.containsKey(curr) && map.get(curr)>=left){
                if(maxLength < right-left){
                    maxLength = right-left;
                }
                left = map.get(curr)+1;
                map.put(curr, right);
            }else{
                map.put(curr, right);
            }

            right++;
        }

        if(right-left > maxLength){
            maxLength = right-left;
        }

        return maxLength;
    }
}
