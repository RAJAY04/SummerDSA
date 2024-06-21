package dp.dpOnLIS;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(tabulation(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return memo(nums,0,-1,dp);//index should be taken in states not values
    }
    public static int memo(int[] nums, int index, int prev , int[][] dp ){
        if(index == nums.length)return 0;

        if(dp[index][prev + 1] != -1)return dp[index][prev + 1];

        int take = 0 , noTake = 0;
        if(prev == - 1 || nums[index] > nums[prev]){//handling this case is very imp
            take = 1 + memo(nums,index + 1, index,dp);
        }
        noTake = memo(nums,index + 1,prev,dp);

        return dp[index][prev + 1] = Math.max(take,noTake);
    }
    public static int tabulation(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0 ;i--){
            for (int prev = i - 1; prev >= -1; prev--) {
                int take = 0, noTake = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    take = 1 + dp[i + 1][i + 1]; // note prev + 1 becomes i + 1 here
                }
                noTake = dp[i + 1][prev + 1]; // note prev + 1

                dp[i][prev + 1] = Math.max(take, noTake);
            }
        }
        return dp[0][0];
    }
}//space optimisation also possilbe

