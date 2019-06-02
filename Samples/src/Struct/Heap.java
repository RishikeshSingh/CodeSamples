package Struct;
import SampleUtilities.Utils;

public class Heap {
    class MinHeap{
        int heapSize;
        int capacity;
        int heapArray[];

        public MinHeap(int capacity){
            this.capacity = capacity;
            this.heapSize = 0;
            this.heapArray = new int[capacity];
        }

        void swap(int arr[], int left, int right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }

        public void add(int data){
            if(heapSize == capacity){
                System.out.printf("Stack overflow");
                return;
            }
            heapSize++;
            heapArray[heapSize-1] = data;
            int i = heapSize-1;
            while (i!=0 && heapArray[i]<heapArray[(i-1)/2]){
                swap(heapArray, i, (i-1)/2);
                i = i-1/2;
            }
        }

        public int extractMin(){
            int temp = heapArray[0];
            heapArray[0] = heapArray[heapSize-1];
            heapSize--;
            minHeapify(heapArray, 0, heapSize);
            return temp;

        }

        public void minHeapify(int[] arr, int index, int len){
            int max = index;
            int left = index*2+1;
            int right = index*2+2;
            if(left<len && arr[max]>arr[left]){
                max = left;
            }
            if(right<len && arr[max]>arr[right]){
                max = right;
            }

            if(max != index){
                swap(arr, index, max);
                minHeapify(arr, max,len);
            }

        }

        public void display(){
            for(int i=0;i<heapSize;i++){
                System.out.print(heapArray[i]+" ");
            }
            System.out.println();
        }

        public int[] heapSort(int[] arr, int len){
            for(int i=(len-1)/2;i>=0;i--){
                minHeapify(arr, i, len);
            }

            int result[] = new int[len];
            for(int i=len-1; i>=0; i--){
                result[len-1-i] = arr[0];
                arr[0] = arr[len-1];
                minHeapify(arr, 0, len);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Heap.MinHeap k = new Heap().new MinHeap(10);
        int values[] = {1,2,4,5,6};
        for(int i=0;i<values.length;i++){
            k.add(values[i]);
        }
        k.display();
        k.add(3);
        while(k.heapSize>0){
            System.out.print(k.extractMin()+" ");
        }
        k.display();

        int unordered[] = {3,6,2,1,5,7};
        int sortedArray[] = k.heapSort(unordered, unordered.length);
        Utils.displayArray(sortedArray);
    }


}
