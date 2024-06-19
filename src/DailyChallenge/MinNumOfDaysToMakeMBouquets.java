package DailyChallenge;

import java.util.Arrays;

public class MinNumOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay,m,k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long)k * m > bloomDay.length)return -1;
        int maxDays = Arrays.stream(bloomDay).max().getAsInt();
        int s = 1, e = maxDays;
        while( s < e){
            int mid = s + (e - s)/ 2;
            if(isPossible(bloomDay,m,k,mid)){
                e = mid;
            }else s = mid + 1;
        }
        return s;
    }

    public static boolean isPossible(int[] bloomDay, int m, int k , int mid){
        int curK = 0;
        for(int i = 0 ; i < bloomDay.length ; i++){
            if(bloomDay[i] <= mid){
                curK++;
            }else curK = 0;
            if(curK == k){
                curK = 0;
                m--;
            }
            if(m == 0)return true;
        }
        return false;
    }
}
