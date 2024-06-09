package LeetCodeContests.Weekly401;

import java.util.Arrays;

public class MaximumTotalReward {
    public static void main(String[] args) {
        int[] rewardValues = {7,15,14,10,2,12};
        System.out.println(maxTotalReward(rewardValues));
    }
    public static int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        int sum = 0;
        int max = 0;
        int[][] dp  = new int[n][4000001];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return memo(rewardValues, 0,0,dp);
    }
    public static int memo(int[] nums,int n, int sum, int[][] dp){
        if(n == nums.length)return sum;
        if(dp[n][sum] != -1)return dp[n][sum];
        int take = Integer.MIN_VALUE, noTake = 0;
            if(sum < nums[n]){
                take = memo(nums, n + 1, sum + nums[n] , dp);
            }
            noTake = memo(nums, n + 1, sum ,dp);
        return dp[n][sum] = Math.max(take,noTake);
    }
}
