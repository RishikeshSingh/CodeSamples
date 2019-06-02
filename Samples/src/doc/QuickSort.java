package doc;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7, 9};
        quickSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void quickSort(int arr[], int low, int high){
        if(low<high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);

        }
    }

    static int partition(int arr[], int low, int high){
        int i=low-1;
        int pivot = arr[high];
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int buff = arr[i];
                arr[i] = arr[j];
                arr[j] = buff;
            }
        }
        i++;
        int buff = arr[i];
        arr[i] = arr[high];
        arr[high] = buff;
        return i;
    }

}

