package Design.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node{
    HashMap<String, Node> map;
    boolean isUsingMap = false;
    boolean isUsingList = false;
    ArrayList<String> list;

    Node(){
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    Node(String type){
        map = new HashMap<>();
        list = new ArrayList<>();
        if(type.equals("list")){
            isUsingList = true;
        }
        if(type.equals("map")){
            isUsingMap = true;
        }
    }
}
public class JSONConstructor {
    public static void main(String[] args) {
        String[] inputs = {"a>b = 5", "a>b = 6", "a>c>d = 7", "a>c>e = 8"};
        //overlapping test cases:
        //String[] inputs = {"a>b = 5", "a>b = 6", "a>c>d = 7", "a>c>e = 8", "a>b>d = 9"};
        //String[] inputs = {"a>b = 5", "a>b = 6", "a>c>d = 7", "a>c>e = 8", "a>c = 17"};

        //String[] inputs = {"a = 5"};
        //String[] inputs = {};
        System.out.printf(getJSONString(inputs));
    }

    static String getJSONString(String[] inputs){
        HashMap structure = createStructure(inputs);
        if(structure == null){
            return "structure of already formed object cannot be changed";
        }
        String json[] = {""};
        createJSONString(structure, json, 0);
        return json[0];
    }

    static HashMap<String, Node> createStructure(String[] inputs){
        HashMap<String, Node> structure = new HashMap<>();
        for(int i=0;i<inputs.length;i++){
            String expression[] = inputs[i].split(" ");
            String value = expression[2];
            String sequence[] = expression[0].split(">");
            boolean creation = insertValue(structure, sequence, value, sequence.length-1, 0);
            if(!creation){
                return null;
            }
        }

        return structure;
    }

    static boolean insertValue(HashMap<String, Node> structure, String[] sequence, String value, int len, int level){
        if(level == len){
            if(structure.containsKey(sequence[level])){
                if(structure.get(sequence[level]).isUsingMap){
                    return false;
                }else{
                    structure.get(sequence[level]).list.add(value);
                    structure.get(sequence[level]).isUsingList = true;
                    return true;
                }
            }else{
                structure.put(sequence[level], new Node("list"));
                structure.get(sequence[level]).list.add(value);
                return true;
            }
        }else{
            if(structure.containsKey(sequence[level])){
                if(structure.get(sequence[level]).isUsingList){
                    return false;
                }
                return insertValue(structure.get(sequence[level]).map, sequence, value, len, level+1);
            }else{
                structure.put(sequence[level], new Node("map"));
                return insertValue(structure.get(sequence[level]).map, sequence, value, len, level+1);
            }
        }
    }

    static void createJSONString(HashMap<String, Node> structure, String str[], int distance){
        int size = structure.size()-1;
        str[0] += "{\n";
        distance++;
        for(Map.Entry<String, Node> itr: structure.entrySet()){
            for(int i=0;i<distance;i++){
                str[0] += "    ";
            }
            str[0] += "\""+itr.getKey()+"\":";
            if(itr.getValue().isUsingList){
                if(itr.getValue().list.size()==1){
                    str[0] += itr.getValue().list.get(0);
                }else{
                    int listsize = itr.getValue().list.size()-1;
                    str[0] += "[";
                    for(String val: itr.getValue().list){
                        str[0] += val;
                        if(listsize>0){
                            str[0] += ",";
                        }
                        listsize--;
                    }
                    str[0] += "]";
                }
            }else if(itr.getValue().isUsingMap){
                createJSONString(itr.getValue().map, str, distance);
            }

            size--;
            if(size>0){
                str[0] += ",";
            }
            str[0] += "\n";
        }

        distance--;
        for(int i=0;i<distance;i++){
            str[0] += "    ";
        }
        str[0] += "}\n";
    }

}
