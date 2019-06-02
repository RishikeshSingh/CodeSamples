package Struct;

class LinkedNode{
    int data;
    LinkedNode next;

    LinkedNode(int val){
        this.data = val;
    }

}
public class LinkedList {

    public static void main(String[] args) {
        LinkedList k = new LinkedList();
        int data[] = {1,2,3,1};
        for(int i=0; i<data.length; i++){
            k.add(data[i]);
        }
        k.display();
        System.out.println(k.checkPalindrome(k.head));
        k.display();
    }

    LinkedNode head;

    void add(int val){
        if(head == null){
            head = new LinkedNode(val);
        }else{
            LinkedNode ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = new LinkedNode(val);
        }

    }

    void display(){
        LinkedNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
    }

    LinkedNode reverseKNodes(LinkedNode head, int span){
        LinkedNode current = head;
        LinkedNode prev = null;
        LinkedNode next = null;
        int counter = 0;

        while (counter < span && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            counter++;
        }

        if(current != null){
            head.next = reverseKNodes(next, span);
        }

        return prev;
    }

    boolean checkPalindrome(LinkedNode head){
        LinkedNode prev = null;
        LinkedNode sptr = head;
        LinkedNode fptr = head;
        LinkedNode next = null;
        boolean flag = true;
        while(fptr != null && fptr.next!=null){
            prev = sptr;
            sptr = sptr.next;
            fptr = fptr.next;
            fptr = fptr.next;
        }
        LinkedNode anchor = prev;
        LinkedNode current;
        if(fptr == null){
            current = sptr;
        }else{
            anchor = sptr;
            current = sptr.next;
        }
        //start reversing
        prev = null; //break the linkage
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        anchor.next = prev;
        anchor = anchor.next;
        //start comparision
        sptr = head; fptr = anchor;
        System.out.println("status of both: "+sptr.data+" "+fptr.data);
        while(fptr != null){
            if(sptr.data != fptr.data){
                return false;
            }
            sptr = sptr.next;
            fptr = fptr.next;
        }
        return true;
    }




}
