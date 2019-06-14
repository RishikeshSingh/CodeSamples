package GFG;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSorted {

    class Node{
        int row;
        int value;

        Node(int row, int value){
            this.row = row;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1,3,5,7,9},{2,4,6,8,10},{5,12,19,54,62}};
        MergeKSorted obj = new MergeKSorted();
        ArrayList<Integer> list = mergeKLists(mat, obj);
        for(Integer i: list){
            System.out.println(i);
        }
    }

    static ArrayList<Integer> mergeKLists(int[][] matrix, MergeKSorted obj){
        int pointers[] = new int[matrix.length];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if(node1.value<node2.value){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        int colSize = matrix[0].length;
        ArrayList<Integer> mergedList = new ArrayList<>();

        boolean flag = true;
        for(int i=0;i<matrix.length;i++){
            pq.add(obj.new Node(i, matrix[i][0]));
            pointers[i]++;
        }
        while (pq.peek().value != Integer.MAX_VALUE){
            Node node = pq.remove();
            System.out.print(node.value+" ");
            pointers[node.row]++;
            mergedList.add(node.value);
            if(pointers[node.row]>=colSize){
                pq.add(obj.new Node(node.row, Integer.MAX_VALUE));
            }else{
                pq.add(obj.new Node(node.row, matrix[node.row][pointers[node.row]]));
            }

        }
        System.out.println(pq.peek().value);

        return mergedList;
    }

    //if multiple linked lists are given then check for all null cases instead
    /*boolean checkEndCase(int[] pointers, int colSize){
        boolean cond = false;
        for(int i:pointers){
            if(i!=colSize){
                return true;
            }
        }

        return cond;
    }*/
}
