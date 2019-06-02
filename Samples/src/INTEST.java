import java.util.Scanner;

public class INTEST {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int entries = sc.nextInt();
        int divisor = sc.nextInt();
        int arr[] = new int[entries];
        for(int i=0;i<entries;i++){
            arr[i] = sc.nextInt();
        }
        int counter=0;
        for(int i=0;i<entries;i++){
            if(arr[i]%divisor == 0){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
