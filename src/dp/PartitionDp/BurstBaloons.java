package dp.PartitionDp;

import java.util.Arrays;

public class BurstBaloons {
    public static void main(String[] args) {
        int[] arr = {3,1,5,8};
        System.out.println(maxCoins(arr));
        System.out.println(tabulation(arr));
        System.out.println(mcm(arr,4));
    }
    public static int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        for(int i = 1; i <= nums.length; i++){
            arr[i] = nums[i - 1];
        }
        int n = arr.length;

        arr[0] = 1 ;
        arr[n - 1] = 1;
        int[][] dp = new int[n][n];
        for(int[] array : dp) Arrays.fill(array,-1);

        return memo(arr,1,n - 2,dp);
    }
    public static int memo(int[] nums, int i , int j, int[][] dp){
        if(i > j)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int ans = Integer.MIN_VALUE;
        for(int k = i ; k <= j; k++){
            int coins = (nums[i - 1] * nums[k] * nums[j + 1]) + memo(nums,i,k - 1,dp) + memo(nums,k + 1, j,dp);
            ans = Math.max(ans,coins);
        }
        return dp[i][j] = ans;
    }

    public static int tabulation(int[] nums){
        int[] arr = new int[nums.length + 2];
        for(int i = 1; i <= nums.length; i++){
            arr[i] = nums[i - 1];
        }
        int n = arr.length;

        arr[0] = 1 ;
        arr[n - 1] = 1;
        int[][] dp = new int[n][n];

        for(int i = n - 2; i >= 1 ;i--){
            for(int j = 1; j <= n - 2; j++){
                if(i > j)continue;
                int ans = Integer.MIN_VALUE;
                for(int k = i ; k <= j; k++){
                    int coins = (arr[i - 1] * arr[k] * arr[j + 1]) + dp[i][k - 1] + dp[k + 1][j];
                    ans = Math.max(ans,coins);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n - 2];
    }
    public static int mcm(int[] arr,int n){
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 1 ; i--){
            for(int j = i + 1 ; j < n; j++){
                int minSteps = Integer.MAX_VALUE;

                for(int k = i; k < j ; k++){
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    minSteps = Math.min(steps,minSteps);
                }
                dp[i][j] = minSteps;
            }
        }
        return dp[1][n - 1];
    }
}
