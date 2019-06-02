package GFG;

public class MinimumDiffBwAnyPair {
    public static void main(String[] args) {
        int arr[] = {3,5,2,4,7};
        System.out.println(findMinimum(arr));
    }

    static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        qsort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length-1;i++){
            if(min>Math.abs(arr[i+1]-arr[i])){
                min = Math.abs(arr[i+1]-arr[i]);
            }
        }
        return min;
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static int partition(int[] arr, int left, int right){
        int pivot = right;
        int i=left, j=left;
        while(j<pivot){
            if(arr[j]<arr[pivot]){
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr, i, pivot);
        return i;
    }


    static void qsort(int[] arr, int left, int right){

        if(left>right){
            return;
        }

        int pi = partition(arr, left, right);

        qsort(arr, left, pi-1);
        qsort(arr, pi+1, right);
    }




}
