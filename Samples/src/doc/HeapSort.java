package doc;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7, 9};
        int k[] = heapsort(arr);
        for(int i=0;i<k.length;i++)
            System.out.print(arr[i]+" ");
    }

    static void heapify(int arr[], int i, int n){

        int max = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left]>arr[max]){
            max = left;
        }
        if(right<n && arr[right]>arr[max]){
            max = right;
        }

        if(max != i){
            int buff = arr[i];
            arr[i] = arr[max];
            arr[max] = buff;
            heapify(arr, max, n);
        }
    }

    static int[] heapsort(int arr[]){
        int n = arr.length;

        //build heap
        for(int i=n/2-1;i>=0;i--){
            heapify(arr, i, n);
        }

        for(int i=n-1;i>=0;i--){
            int buff = arr[i];
            arr[i] = arr[0];
            arr[0] = buff;
            heapify(arr, 0, i);
        }

        return arr;
    }

}


