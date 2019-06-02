import java.util.*;

public class ZittoRound3 {
    public static void main(String[] args) {
        String[][] map = {{"jupiter","saturn"},{"cat","rat"},{"jp","rs"},{"charisma", "jostiness"},{"r","s"}};
        //createGraph(map);
        //System.out.println(findFirstNode(map));
        findOrdering(map);
    }

    static char[] compareTokens(String st1, String st2){
        for(int i=0; i<Math.min(st1.length(), st2.length());i++){
            if(st1.charAt(i) != st2.charAt(i)){
                char arr[] = new char[2];
                arr[0] = st1.charAt(i);
                arr[1] = st2.charAt(i);
                return arr;
            }
        }
        return null;
    }

    static HashMap<Character, ArrayList<Character>> createGraph(String[][] map){
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        for(int i=0;i<map.length;i++){
            char[] charPair = compareTokens(map[i][0], map[i][1]);
            if(graph.containsKey(charPair[0])){
                graph.get(charPair[0]).add(charPair[1]);
            }else{
                ArrayList<Character> charList = new ArrayList<>();
                charList.add(charPair[1]);
                graph.put(charPair[0], charList);
            }
        }

        return graph;
    }

    static char findFirstNode(String[][] map){
        char head = compareTokens(map[0][0], map[0][1])[0];
        for(int i=1;i<map.length;i++) {
            char[] charPair = compareTokens(map[i][0], map[i][1]);
            if(charPair[1] == head){
                head = charPair[0];
            }
        }

        return head;
    }

    static void topologicalSortUtil(char curr, HashMap<Character, ArrayList<Character>> graph, Stack st, HashSet visited){
        if(graph.get(curr) != null){
            for(char ch: graph.get(curr)){
                if(!visited.contains(ch)){
                    visited.add(ch);
                    topologicalSortUtil(ch, graph, st, visited);
                }
            }
        }
        st.push(curr);
    }

    static void topologicalSort(char start, HashMap<Character, ArrayList<Character>> graph){
        HashSet<Character> visited = new HashSet<>();
        Stack<Character> st = new Stack<>();
        //crate unique character list and start traversing
        HashSet<Character> unique = new HashSet<>();
        ArrayList<Character> allCharacters = new ArrayList<>();
        allCharacters.add(start);
        unique.add(start);
        for(HashMap.Entry hm : graph.entrySet()){
            for(char ch : graph.get(hm.getKey())){
                if(!unique.contains(ch)){
                    allCharacters.add(ch);
                    unique.add(ch);
                }
            }
        }

        for(char ch: allCharacters){
            if(!visited.contains(ch)){
                visited.add(ch);
                topologicalSortUtil(ch, graph, st, visited);
            }
        }

        while (!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    static void findOrdering(String[][] map){
        HashMap<Character, ArrayList<Character>> graph = createGraph(map);
        char start = findFirstNode(map);
        topologicalSort(start, graph);
    }
}
