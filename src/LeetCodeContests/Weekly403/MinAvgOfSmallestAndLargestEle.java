package LeetCodeContests.Weekly403;

import java.util.Arrays;

public class MinAvgOfSmallestAndLargestEle {
    public static void main(String[] args) {
        int[] nums = {3,3,4,3,3};
        System.out.println(new MinAvgOfSmallestAndLargestEle().minimumAverage(nums));
    }
    public static double minimumAverage(int[] nums) {
        int n = nums.length , i = 0;
        Arrays.sort(nums);
        int j = n - 1;
        double min = Integer.MAX_VALUE , avg = 0;
        while (i < j){
            avg = (double)(nums[i] + nums[j])/2;
            min = Math.min(min,avg);
            i++;
            j--;
        }
        return min;
    }
}
