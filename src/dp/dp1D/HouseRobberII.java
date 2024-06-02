package dp.dp1D;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {200,3,140,20,10};
        System.out.println(rob(nums));
        System.out.println(Math.max(tabulation0(nums,nums.length - 2),tabulation1(nums,nums.length - 1)));
        System.out.println(Math.max(spaceOptimization0(nums,nums.length - 2),spaceOptimization1(nums,nums.length - 1)));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1)return nums[0];
        Integer[] dp0 = new Integer[n];
        Integer[] dp1 = new Integer[n];//done use same dp array remember
        return Math.max(memoization0(nums,n - 2,dp0),memoization1(nums,n - 1,dp1));
    }
    public static int memoization0(int[] nums, int n , Integer[] dp){
        if(n == 0)return nums[n];
        if(n < 0)return 0;
        if(dp[n] != null)return dp[n];
        int pick = memoization0(nums,n - 2,dp) + nums[n];
        int noPick = memoization0(nums,n - 1, dp);
        return dp[n] = Math.max(pick,noPick);
    }
    public static int memoization1(int[] nums, int n , Integer[] dp){
        if(n == 1)return nums[n];
        if(n < 1)return 0;
        if(dp[n] != null)return dp[n];
        int pick = memoization1(nums,n - 2,dp) + nums[n];
        int noPick = memoization1(nums,n - 1, dp);
        return dp[n] = Math.max(pick,noPick);
    }
    public static int tabulation0(int[] nums, int n){
        int[] dp = new int[n + 2];
        dp[0] = nums[0];
        int pick = 0 , noPick = 0;
        int max = 0;
        for(int i = 1; i <= n ; i++){
            if(i < 2){
                pick = nums[i];
            }else {
                pick = dp[i - 2] + nums[i];
            }
            noPick = dp[i - 1];
            dp[i] =  Math.max(pick,noPick);
        }
        return dp[dp.length - 2];
    }
    public static int tabulation1(int[] nums, int n){
        int[] dp = new int[n + 1];
        dp[1] = nums[1];
        int pick = 0 , noPick = 0;
        int max = 0;
        for(int i = 2; i <= n ; i++){
            if(i < 3){
                pick = nums[i];
            }else {
                pick = dp[i - 2] + nums[i];
            }
            noPick = dp[ i - 1];
            dp[i] =  Math.max(pick,noPick);
        }
        return dp[dp.length -1];
    }
    public static int spaceOptimization0(int[] nums, int n){
        int prev = nums[0], prev2 = 0;
        int pick = 0 , noPick = 0;
        int cur = 0;
        for(int i = 1; i <= n ; i++){
            pick = prev2 + nums[i];
            noPick = prev;
            cur =  Math.max(pick,noPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
    public static int spaceOptimization1(int[] nums, int n){
        int prev = nums[1], prev2 = 0;
        int pick = 0 , noPick = 0;
        int cur = 0;
        for(int i = 2; i <= n ; i++){
            pick = prev2 + nums[i];
            noPick = prev;
            cur =  Math.max(pick,noPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
