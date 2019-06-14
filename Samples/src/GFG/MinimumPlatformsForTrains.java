package GFG;

import java.util.Arrays;

public class MinimumPlatformsForTrains {

    public static void main(String[] args) {
        double[] arr = {9.00,  9.40, 9.50,  11.20, 15.00, 18.00};
        double[] dep = {9.10, 12.00, 11.20, 11.30, 19.00, 20.00};
        System.out.println(requiredPlatforms(arr, dep));
    }

    static int requiredPlatforms(double arrival[], double[] departure){
        int len = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i=0;
        int j=0;
        int max=0;
        int curr=0;
        while(i<len){
            if(arrival[i]<departure[j]){
                i++;
                curr++;
                if(max<curr){
                    max=curr;
                }
            }else{
                j++;
                curr--;
            }
        }

        return max;

    }
}
