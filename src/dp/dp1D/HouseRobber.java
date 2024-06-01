package dp.dp1D;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        Integer[] dp = new Integer[nums.length];
        System.out.println(memoization(nums,nums.length - 1,dp));
        System.out.println(tabulation(nums));
    }
    public static int memoization(int[] nums,int n , Integer[] dp){
        if(n < 0)return 0;
        if(n == 0)return nums[0];
        int pick = 0;
        if(dp[n] != null)return dp[n];
        int skip = 0;
        pick = dfs(nums,n - 2,dp) + nums[n];
        skip = dfs(nums,n - 1,dp);
        return dp[n] = Math.max(pick,skip);
    }
    public static int tabulation(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int neg = 0;
        int take = 0 , noTake = 0;
        for(int i = 1; i < nums.length ; i++){
            if(i <= 1){
                take = nums[i] + neg;
            }else take = nums[i] + dp[i - 2];
            noTake = dp[i - 1];
            dp[i] = Math.max(take,noTake);
        }
        return dp[nums.length - 1];
    }
    public static int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0 , cur = 0;
        int take = 0 , noTake = 0;
        for(int i = 1; i < nums.length ; i++){
            if(i <= 1){
                take = nums[i] + prev2;
            }else take = nums[i] + prev2;
            noTake = prev;
            cur = Math.max(take,noTake);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
