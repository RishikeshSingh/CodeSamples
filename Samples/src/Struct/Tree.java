package Struct;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left, right;

    Node(int value){
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
    Node root;

    Tree(){
        Node root = null;
    }

    void levelOrder(){
        Queue<Node> queue = new LinkedList();
        queue.add(this.root);
        int nodeCount;
        while(!queue.isEmpty()){
            nodeCount = queue.size();
            Node temp;
            while(nodeCount>0){
                temp = queue.remove();
                System.out.print(temp.data+" ");
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    Node addUtil(int data, Node ptr){
        if(this.root == null){
            Node node = new Node(data);
            this.root = node;
            return node;
        }

        if(ptr != null){
            if(ptr.data < data){
                ptr.right = addUtil(data, ptr.right);
            }else{
                ptr.left = addUtil(data, ptr.left);
            }
        }else{
            Node node = new Node(data);
            return node;
        }

        return ptr;
    }

    void add(int data){
        addUtil(data, this.root);
    }

    int findPredecessor(Node ptr){
        while(ptr.right!=null){
            ptr = ptr.right;
        }

        return  ptr.data;
    }

    Node deleteUtil(int value, Node ptr){
        //System.out.println("marker"+ptr.data);
        if(ptr == null){
            return ptr;
        }

        if(ptr.data == value){
            //delete condition
            if(ptr.left == null && ptr.right == null){
                return  null;
            } else
            if(ptr.left == null){
                return ptr.right;
            } else
            if(ptr.right == null){
                return ptr.left;
            } else {
                int key = findPredecessor(ptr.left);
                deleteUtil(key, ptr.left);
                ptr.data = key;
                return ptr;
            }
        }else{
            if(ptr.data < value){
                ptr.right = deleteUtil(value, ptr.right);
            }else{
                ptr.left = deleteUtil(value, ptr.right);
            }
        }

        return  ptr;
    }

    void delete(int data){
        deleteUtil(data, this.root);
    }

    int maximumPathSum(Node root, int[] max){
        if(root == null){
            return 0;
        }

        int left = maximumPathSum(root.left, max);
        int right = maximumPathSum(root.right, max);
        if(left+right+root.data > max[0]){
            max[0] = left+right+root.data;
        }

        return Math.max(left+root.data, right+root.data);
    }

    boolean bst(Node root){
        if(root == null){
            return true;
        }

        if(root.left != null && root.left.data>root.data){
            return false;
        }

        if(root.right != null && root.right.data<root.data){
            return false;
        }

        return bst(root.left) && bst(root.right);
    }

    public static void main(String[] args) {
        /*Tree tree = new Tree();
        tree.add(5);
        tree.add(9);
        tree.add(2);
        tree.add(11);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        System.out.println(tree.root.data);
        System.out.println(tree.root.left.data);
        System.out.println(tree.root.right.data);
        System.out.println(tree.root.right.right.data);
        System.out.println(tree.root.right.left.data);
        tree.delete(9);
        System.out.println("///////////////////");
        System.out.println(tree.root.data);
        System.out.println(tree.root.left.data);
        System.out.println(tree.root.right.data);
        System.out.println(tree.root.right.right.data);
        System.out.println(tree.root.right.left.data);
        System.out.println("////////////////////////");
        tree.levelOrder();
        int arr[] = {0};
        tree.maximumPathSum(tree.root, arr);
        System.out.printf("max sum : "+arr[0]);
        System.out.println(tree.bst(tree.root));*/
        //testing by creating normal binary tree
        Tree tree = new Tree();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.right.left = new Node(6);
        System.out.println(tree.bst(tree.root));

    }
}
