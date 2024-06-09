package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        int n = 6;
        System.out.println(maxMeetings(start,end,n));
    }
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int endtime = arr[0][1];
        for(int i = 1; i < n; i++) {
            if(arr[i][0] > endtime) {
                count++;
                endtime = arr[i][1];
            }
        }
        return count;
    }
}
