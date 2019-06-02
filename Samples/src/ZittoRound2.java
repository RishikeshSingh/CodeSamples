import java.util.HashMap;
import java.util.HashSet;

public class ZittoRound2 {
    //make possible sentences present in dictionary
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("cde");
        dict.add("ab");
        dict.add("cd");
        dict.add("e");
        System.out.println(calcCombinations("abcde", dict, ""));
    }

    static int calcCombinations(String str, HashSet<String> dict, String sentence){
        if(str.length() <= 0){
            System.out.println("complete sentence : "+sentence);
            return 1;
        }
        int count = 0;
        for(int i=1;i<=str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i);
            if(dict.contains(left)){
                count += calcCombinations(right, dict, sentence+" "+left);
            }

        }

        return count;
    }
}
