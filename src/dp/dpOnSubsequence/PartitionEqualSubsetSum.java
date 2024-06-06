package dp.dpOnSubsequence;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
        System.out.println(tabulation(nums));
        System.out.println(spaceOptimisation(nums));
    }
    public static boolean canPartition(int[] nums) {
        int target = 0;
        for(int num : nums)target += num;
        if(target % 2 != 0)return false;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n + 1][(target/2) + 1];
        return memo(nums,n -1 ,target/2,dp);
    }
    public static boolean memo(int[] nums,int n,int target,Boolean[][] dp){
        if(n == 0){
            return nums[0] == target;
        }

        if(dp[n][target] != null)return dp[n][target];

        boolean include = false;
        if(target >= nums[n]) include = memo(nums, n - 1, target - nums[n],dp);
        boolean exclude = memo(nums,n - 1, target,dp);

        return dp[n][target] = include | exclude;
    }
    public static boolean tabulation(int[] nums){
        int n = nums.length;
        int target = 0;
        for(int num: nums)target+= num;
        if (target % 2 != 0)return false;
        target/= 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = true;//true for base case
        }

        for(int i = 1; i < n ; i ++){
            for(int j = 1; j <= target; j++){
                boolean include = false;
                if(j >= nums[i]) include = dp[i - 1][j - nums[i]];
                boolean exclude = dp[i - 1][j];
                dp[i][j] = include | exclude;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][target];
    }
    public static boolean spaceOptimisation(int[] nums){
        int n = nums.length;
        int target = 0;
        for(int num: nums)target+= num;
        if (target % 2 != 0)return false;
        target/= 2;
        boolean[] cur = new boolean[target + 1];
        boolean[] prev = new boolean[target + 1];

        for(int i = 1; i < n ; i ++){
            prev[0] = true;
            cur = new boolean[target + 1];
            for(int j = 1; j <= target; j++){
                boolean include = false;
                if(j >= nums[i]) include = prev[j - nums[i]];
                boolean exclude = prev[j];
                cur[j] = include | exclude;
            }
            prev = cur.clone();
        }
        return prev[target];
    }
}
