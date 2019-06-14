package GFG;

import java.util.HashMap;


public class KMostFrequent {

    class Node{
        String word;
        int frequency;
        int index = -1;

        Node(String word, int frequency, int index){
            this.word = word;
            this.frequency = frequency;
            this.index = index;
        }

        Node(String word, int frequency){
            this.word = word;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        KMostFrequent obj = new KMostFrequent();
        String arr[] = {"cat","cat","dog","rat","cow","cow","horse","horse","horse","lynx","lynx","lynx","lynx"};
        returnKMostFrequent(arr, 4, obj);
    }

    static void swap(Node[] arr, int l, int r){
        Node temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        int tempIndex = arr[l].index;
        arr[l].index = arr[r].index;
        arr[r].index = tempIndex;
    }

    static void heapify(Node[] arr, int index, int size){

        int max = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if(left<=size && arr[max].frequency>arr[left].frequency){
            max = left;
        }

        if(right<=size && arr[max].frequency>arr[right].frequency){
            max = right;
        }

        if(max!=index){
            swap(arr, max, index);
            heapify(arr, max, size);
        }
    }

    static void add(Node[] arr, Node node, int index){
        arr[index]  = node;
        while(index !=0 || arr[index].frequency<arr[(index-1)/2].frequency){
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    static void returnKMostFrequent(String words[], int size, KMostFrequent obj){
        int len = words.length;
        HashMap<String, Node> map = new HashMap<>();
        Node[] frequentWords = new Node[size];
        int curr = 0;

        //last element exists at curr-1 always, at start last element exists before 0 i.e. doesn't exist
        for(String str: words){
            if(map.containsKey(str)){
                Node temp = map.get(str);
                temp.frequency++;
                if(temp.index>-1){
                    heapify(frequentWords, temp.index, curr-1);
                }else{
                    if(frequentWords[0].frequency<temp.frequency){
                        frequentWords[0].index = -1;
                        temp.index = 0;
                        frequentWords[0]  = temp;
                        heapify(frequentWords, 0, curr-1);
                    }
                }
            }else{
                Node node;
                if(curr<size){
                    node = obj.new Node(str, 1, curr);
                    add(frequentWords, node, curr);
                    curr++;
                }else{
                    node = obj.new Node(str, 1);
                }

                map.put(str, node);
            }
        }

        curr--;
        //print k frequent words
        while(curr>=0){
            System.out.println(frequentWords[0].word+" "+frequentWords[0].frequency);
            swap(frequentWords, 0, curr);
            curr--;
            heapify(frequentWords, 0 , curr);

        }
    }
}
