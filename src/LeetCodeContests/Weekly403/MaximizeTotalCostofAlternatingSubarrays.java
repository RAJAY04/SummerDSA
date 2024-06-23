package LeetCodeContests.Weekly403;

public class MaximizeTotalCostofAlternatingSubarrays {
    public static void main(String[] args) {
        int[] nums = {-637};
        System.out.println(maximumTotalCost(nums));
    }
    public static long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][][] dp = new long[n][2][2];//fresh or continue and +Ve or -Ve
        for(int i = 0 ; i <n; i++){
            for(int j = 0 ; j < 2; j++){
                for(int k = 0 ; k < 2; k++){
                    dp[i][j][k] = Long.MAX_VALUE;
                }
            }
        }

        return memo(nums,0,0,0,dp);
    }
    public static long memo(int[] nums,int i ,int isFresh,int isPositive, long[][][] dp){
        if( i == nums.length)return 0;

        if(dp[i][isFresh][isPositive] != Long.MAX_VALUE)return dp[i][isFresh][isPositive];

        long fresh = Long.MIN_VALUE, cont = Long.MIN_VALUE , ans = 0;
        if(isFresh == 0){
            ans = nums[i] + memo(nums,i + 1,1,1,dp);
        }else{
            if(isPositive == 0){
                fresh = memo(nums,i,0,0,dp);
                cont = nums[i] + memo(nums,i + 1, 1,1,dp);
            }else{
                fresh = memo(nums,i,0,0,dp);
                cont = (-1 * nums[i]) + memo(nums,i + 1, 1,0,dp);
            }
        }
        return dp[i][isFresh][isPositive] = Math.max(ans,Math.max(fresh,cont));
    }
}
