package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr,dep,arr.length));
    }
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0 , j = 1;//start from j = 1 , assuming j = 0 train has arrived
        int max =1 , platform = 1;
        while(i < n && j < n){
            if(dep[i] >= arr[j]){
                platform++;
                j++;
            }else{
                platform--;
                i++;
            }
            max = Math.max(platform,max);
        }
        return max;
    }
}
