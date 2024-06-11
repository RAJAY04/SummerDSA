package DailyChallenge;

import java.util.Arrays;

public class RelativeSort {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] freq1 = new int[1001];
        int i = 0 , j = 0;
        while(i < n){
            freq1[arr1[i++]]++;
        }
        j = 0;
        int[] res = new int[n];
        for(i = 0 ; i < m ; i++){
            int num = arr2[i];
            while(freq1[num] > 0){
                res[j++] = num;
                freq1[num]--;
            }
        }
        for (i = 0; i < 1001; i++) {
            while (freq1[i] > 0) {
                res[j++] = i;
                freq1[i]--;
            }
        }

        return res;
    }
}
