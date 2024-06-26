package dp.dpOnLIS;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp =  new int[n];
        int[] count = new int[n];
        int max = 0;

        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
            count[i] = 1;
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[i] > nums[prev] && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    count[i] = count[prev];
                }else if(nums[i] > nums[prev] && dp[prev] + 1 == dp[i]){
                    count[i] = count[i] + count[prev];
                }
            }
            max = Math.max(dp[i],max);
        }

        int finalMax = max;
        int ans = IntStream.range(0,dp.length)
                .filter(i -> dp[i] == finalMax)
                .map(i -> count[i])
                .sum();
        return ans;
        //array:  1 5 4 3 2 6 7 10 8 9
        //length: 1 2 2 2 2 3 4 5  5 6
        //count:  1 1 1 1 1 4 4 4  4 4
    }
}
