package GFG;

public class BitDifference {
    public static void main(String[] args) {
        System.out.println(findBitDifference(10,20));
    }

    static int findBitDifference(int n1, int n2){
        int temp = n1^n2;
        //Integer.toBinaryString(n);
        int pos = 0;
        int count = 0;
        while(temp != 0){
            int buff = temp;
            if(temp != (buff&~(1<<pos))){
                count++;
            }
            temp &= (~(1<<pos));
            pos++;
        }
        return count;
    }
}
