package GFG;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;


public class InterviewScheduling {

    class Span{
        int startTime;
        int endTime;
        int index;

        Span(int startTime, int endTime, int index){
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int ptr=0;ptr<tests;ptr++){
            //int len = sc.nextInt();
            ArrayList<Span> activities = new ArrayList<>();
            int len = 10;
            int arr[][] = {{0,4},{1,2},{2,4},{3,5},{3,6},{5,6},{5,7},{6,8},{7,9},{8,10}};
            /*int start[] = new int[len];
            int end[] = new int[len];
            int t = len;
            for(int i=0;i<len;i++){
                start[i] = sc.nextInt();
            }
            for(int i=0;i<len;i++){
                end[i] = sc.nextInt();
            }*/

            /*for(int i=0;i<len;i++){
                activities.add(new InterviewScheduling(). new Span(start[i], end[i], i+1));
            }*/

            for(int i=0;i<len;i++){
                activities.add(new InterviewScheduling(). new Span(arr[i][0], arr[i][1], i+1));
            }

            sort(activities, 0, len-1);
            pickInterview(activities);
        }

    }

    static void swap(ArrayList<Span> list, int i, int j){
        Span temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    static void sort(ArrayList<Span> activities, int left, int right){
        if(left <= right){
            int pi = sortUtil(activities, left, right);
            sort(activities, left, pi-1);
            sort(activities, pi+1, right);
        }
    }

    static int sortUtil(ArrayList<Span> activities, int left, int right){
        int pivot = activities.get(right).endTime;
        int i=left;
        int j=i;
        while(j<right){
            if(activities.get(j).endTime < pivot){
                swap(activities, i, j);
                i++;
            }
            j++;
        }

        swap(activities, i, right);
        return i;
    }

    static void pickInterview(ArrayList<Span> activities){
        System.out.println("attendable interviews :");
        Span startPoint = new InterviewScheduling(). new Span(-1,-1, -1);
        Span lastspan = startPoint;
        for(Span span: activities){
            if(span.startTime >= lastspan.endTime){
                System.out.print(span.index+" ");
                lastspan = span;
            }
        }
    }
}
