package GFG;


import java.util.ArrayList;
import java.util.Scanner;


public class HowManyRooms {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Span> activities = new ArrayList<>();
        int len = 10;
        int arr[][] = {{0,4},{1,2},{2,4},{8,10},{3,5},{3,6},{5,6},{5,7},{6,8},{7,9}};
        for(int i=0;i<len;i++){
            activities.add(new HowManyRooms(). new Span(arr[i][0], arr[i][1]));
        }

        sort(activities, 0, len-1);

        System.out.println("list of meetings");
        for(Span span: activities){
            System.out.println(span.startTime+" "+span.endTime);
        }

        MinHeap minHeap = new HowManyRooms().new MinHeap();
        for(Span span: activities){
            if(minHeap.len == -1){
                minHeap.add(span);
            }else{
                if(minHeap.rooms.get(0).endTime <= span.startTime){
                    minHeap.rooms.get(0).endTime = span.endTime;
                    minHeap.heapify(0);
                }else{
                    minHeap.add(span);
                }
            }
        }

        System.out.println("total rooms needed : "+(minHeap.len+1));

    }

    class Span{
        int startTime;
        int endTime;

        Span(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    class MinHeap{
        ArrayList<Span> rooms = new ArrayList<>();
        int len=-1;

        void add(Span span){
            if(len == -1){
                rooms.add(span);
                len++;
                return;
            }
            rooms.add(span);
            len++;
            int i = len;
            while(i>0 && span.endTime < rooms.get((i-1)/2).endTime){
                swap(rooms, i, (i-1)/2);
                i = (i-1)/2;
            }
        }

        Span extractMin(){
            Span temp = rooms.get(0);
            swap(rooms, 0, len);
            rooms.set(len, null);
            len--;
            heapify(0);
            return temp;
        }

        void heapify(int index){
                heapifyUtil(rooms, index, len);
        }

        void heapifyUtil(ArrayList<Span> rooms, int index, int len){
            int max = index;
            int left = 2*index+1;
            int right = 2*index+2;
            if(left<=len && rooms.get(left).endTime < rooms.get(max).endTime){
                max = left;
            }
            if(right<=len && rooms.get(right).endTime < rooms.get(max).endTime){
                max = right;
            }

            if(max != index){
                swap(rooms, max, index);
                heapifyUtil(rooms, max, len);
            }
        }

    }

    static void swap(ArrayList<Span> activities, int i, int j){
        Span temp = activities.get(i);
        activities.set(i, activities.get(j));
        activities.set(j, temp);
    }

    static int sortUtil(ArrayList<Span> activities, int left, int right){
        int pivot = activities.get(right).startTime;
        int i=left,j=left;
        while(j<right){
            if(activities.get(j).startTime<pivot){
                swap(activities, i, j);
                i++;
            }
            j++;
        }

        swap(activities, i, right);
        return i;
    }

    static void sort(ArrayList<Span> activities, int left, int right){
        if(left<=right){
            int pi = sortUtil(activities, left, right);

            sort(activities, left, pi-1);
            sort(activities, pi+1, right);
        }
    }


}
