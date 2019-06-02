package doc;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7, 9};
        mergeSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    static void mergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = (high+low)/2;
            mergeSort(arr, 0, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int arr[], int low, int mid, int high){
        int buffer[] = new int[high-low+1];
        int pointer=0;
        int i=low, j=mid+1;
        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                buffer[pointer] = arr[i];
                i++;
            }else{
                buffer[pointer] = arr[j];
                j++;
            }
            pointer++;
        }
        while(i<=mid){
            buffer[pointer] = arr[i];
            i++; pointer++;
        }
        while (j<=high){
            buffer[pointer] = arr[j];
            j++;pointer++;
        }

        pointer = 0;
        for(int ptr=low;ptr<=high;ptr++){
            arr[ptr] = buffer[pointer];
            pointer++;
        }

    }
}
