package GFG;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class OddEvenLevelDifference {
    public static void main(String[] args) {

    }

    static int getLevelDifference(Node node){
        Queue<Node> q = new LinkedList();
        q.add(node);
        boolean positive = true;
        int sum = 0;
        while(!q.isEmpty()){
            int len = q.size();
            while(len>0){
                len--;
                Node temp = q.remove();
                if(positive){
                    sum += temp.data;
                }else{
                    sum -= temp.data;
                }

                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            positive = !positive;
        }

        return sum;
    }
}
