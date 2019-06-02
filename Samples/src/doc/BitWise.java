package doc;

public class BitWise {
    public static void main(String[] args) {
        int n = 10;
        int pos = 3;
        System.out.println(Integer.toBinaryString(n));
        /*n &= ~(1<<(pos-1)); //unset at pos
        //n |= (1<<(pos-1)) | (1<<(pos-2)); // set at pos 2 and 3
        System.out.println(Integer.toBinaryString(n));
        n ^= (1<<(pos-1)) | (1<<(pos-2));   //toggle at pos 2 and 3
        System.out.println(Integer.toBinaryString(n));*/
        int k = n;
        if(n == (k | (1<< pos-1))){
            System.out.println("value is 1");
        }else{
            System.out.printf("value is 0");
        }
    }
}
