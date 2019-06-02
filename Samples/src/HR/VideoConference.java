package HR;

import java.util.HashMap;
import java.util.Scanner;

public class VideoConference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str[] = new String[len];
        for(int i=0;i<len;i++){
            str[i] = sc.next();
        }

        createPrefix(str);
    }

    static class TrieNode{
        TrieNode[] chlild = new TrieNode[26];
    }

    static void createPrefix(String[] stringArray){
        TrieNode FirstHead = new TrieNode();
        HashMap<String, Integer> duplicateNames = new HashMap<>();
        for(int i=0;i<stringArray.length;i++){
            String temp = "";
            boolean modifyTemp = true;
            TrieNode head = FirstHead;
            if(!duplicateNames.containsKey(stringArray[i])){
                duplicateNames.put(stringArray[i], 1);
                for(int j=0;j<stringArray[i].length();j++){
                    if(modifyTemp) {
                        temp += stringArray[i].charAt(j);
                    }
                    if(head.chlild[stringArray[i].charAt(j) - 'a']  == null){
                        head.chlild[stringArray[i].charAt(j) - 'a'] = new TrieNode();
                        modifyTemp = false;
                    }

                    head = head.chlild[stringArray[i].charAt(j) - 'a'];
                }
                System.out.println(temp);

            }else{
                duplicateNames.put(stringArray[i], duplicateNames.get(stringArray[i])+1);
                System.out.println(stringArray[i]+duplicateNames.get(stringArray[i]));
            }

        }
    }
}
