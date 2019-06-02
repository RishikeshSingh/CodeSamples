package Design.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JConstructor {
    public static void main(String[] args) {
        //String[] inputs = {"a>b = 5", "a>b = 6", "a>c>d = 7", "a>c>e = 8", "a>b>d = 9"};
        //String[] inputs = {"a>b = 5", "a>b = 6", "a>c>d = 7", "a>c>e = 8", "a>c = 17"};
        String[] inputs = {"a>b = 5", "a>b = 6", "a>c>d = 7", "a>c>e = 8"};
        System.out.println(printJSON(inputs));
        System.out.println("////////////////////////////");
        System.out.println(prettyPrintJSON(inputs));
    }

    static String printJSON(String[] inputs){
        //taking array as its won't change each time in recursion
        String json[] = {""};
        HashMap<String, Object> structure = createStructure(inputs);
        if (structure == null) {
            return "value already present";
        }
        displayJSON(structure, json);
        return json[0];
    }

    static String prettyPrintJSON(String[] inputs){
        String json[] = {""};
        HashMap<String, Object> structure = createStructure(inputs);
        if (structure == null) {
            return "value already present";
        }
        displayJSONPretty(structure, json, 0);
        return json[0];
    }

    static HashMap<String, Object> createStructure(String[] input){

        boolean validFlag = true;
        HashMap<String, Object> structure = new HashMap<>();
        for(int i=0;i<input.length;i++){
            String expression = input[i];
            String[] expParts = expression.split(" ");
            String value = expParts[2];
            String sequence[] = expParts[0].split(">");
            int len = sequence.length;
            validFlag = insertValue(structure, sequence, 0, len, value);
            if(!validFlag){
                return null;
            }
        }

        return structure;
    }

    static boolean insertValue(HashMap<String, Object> structure, String[] sequence, int level, int len, String value){
        if(level < len-1){
            if(structure.containsKey(sequence[level])){
                //check dataType
                //if its a value return false
                //else move in recursion
                if(!structure.get(sequence[level]).getClass().getName().equals("java.util.HashMap")){
                    return false;
                }else{
                    return insertValue((HashMap<String, Object>) structure.get(sequence[level]), sequence, level+1, len, value);
                }
            }else{
                structure.put(sequence[level], new HashMap<String, Object>());
                return insertValue((HashMap<String, Object>) structure.get(sequence[level]), sequence, level+1, len, value);
            }
        }else{
            if(structure.containsKey(sequence[level])){
                if(structure.get(sequence[level]).getClass().getName().equals("java.util.HashMap")){
                    return false;
                }
                if(structure.get(sequence[level]).getClass().getName().equals("java.lang.String")){
                    String prev = (String) structure.get(sequence[level]);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(prev);
                    arrayList.add(value);
                    structure.put(sequence[level], arrayList);
                }else{
                    ArrayList<String> temp = (ArrayList) structure.get(sequence[level]);
                    temp.add(value);
                    structure.put(sequence[level], temp);
                }
            }else{
                structure.put(sequence[level], value);
            }

            return true;
        }
    }

    static void displayJSON(HashMap<String, Object> structure, String[] json){
        int size = structure.size()-1;
        json[0] += "{";
        for(Map.Entry<String, Object> itr: structure.entrySet()){
            json[0] += itr.getKey()+":";
            if(itr.getValue().getClass().getName().equals("java.util.HashMap")){
                displayJSON((HashMap<String, Object>) itr.getValue(), json);
            }else{
                if(itr.getValue().getClass().getName().equals("java.lang.String")){
                    json[0] += itr.getValue();
                }else{

                    ArrayList<String> list = (ArrayList<String>) itr.getValue();
                    json[0] += "[";
                    for(int i=0;i<list.size()-1;i++){
                        json[0] += list.get(i)+",";
                    }
                    json[0] += list.get(list.size()-1);
                    json[0] += "]";
                }
            }
            if(size>0){
                json[0] += ",";
            }
            size--;
        }
        json[0] += "}";
    }

    static void displayJSONPretty(HashMap<String, Object> structure, String[] json, int distance){
        //to implement one less comma
        int size = structure.size()-1;
        //increasing tabs
        distance++;
        json[0] += "{\n";
        for(Map.Entry<String, Object> itr: structure.entrySet()){
            //tabs before each key
            for(int i=0;i<distance;i++){
                json[0] += "    ";
            }
            json[0] += "\""+itr.getKey()+"\""+":";
            if(itr.getValue().getClass().getName().equals("java.util.HashMap")){

                displayJSONPretty((HashMap<String, Object>) itr.getValue(), json, distance);
            }else{
                if(itr.getValue().getClass().getName().equals("java.lang.String")){
                    json[0] += itr.getValue();
                }else{

                    ArrayList<String> list = (ArrayList<String>) itr.getValue();
                    json[0] += "[";
                    for(int i=0;i<list.size()-1;i++){
                        json[0] += list.get(i)+",";
                    }
                    json[0] += list.get(list.size()-1);
                    json[0] += "]";
                }
            }
            if(size>0){
                json[0] += ",";
            }
            size--;
            json[0] += "\n";
        }
        //decreasing tabs
        distance--;
        //tabs before closing braces
        for(int i=0;i<distance;i++){
            json[0] += "    ";
        }
        json[0] += "}";
    }

}

