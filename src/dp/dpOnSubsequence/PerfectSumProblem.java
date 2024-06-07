package dp.dpOnSubsequence;

import java.util.Arrays;

public class PerfectSumProblem {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 10};
        int n = arr.length;
        int sum = 10;
        System.out.println(perfectSum(arr, n, sum));
        System.out.println(tabulation(arr,n, sum));
        System.out.println(spaceOptimisation(arr,n,sum));
    }
    public static final int MOD = 1000000007;

    public static int perfectSum(int arr[], int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memo(arr, n - 1, sum, dp);
    }

    public static int memo(int[] arr, int n, int sum, int[][] dp) {
        if (sum == 0) return 1;
        if (n == 0) return (sum == arr[n]) ? 1 : 0;
        if (dp[n][sum] != -1) return dp[n][sum];

        int take = 0, dontTake = 0;
        if (arr[n] <= sum) take = memo(arr, n - 1, sum - arr[n], dp);
        dontTake = memo(arr, n - 1, sum, dp);

        return dp[n][sum] = (take % MOD + dontTake % MOD) % MOD;
    }

    public static int tabulation(int[] arr, int n , int sum){
        int[][] dp = new int[n][sum + 1];
        for(int i = 0 ; i < n ; i ++){
            dp[i][0] = 1;
        }
        dp[0][arr[0]] = 1;

        for(int i = 1; i < n ; i++){
            int take = 0 , noTake = 0;//if you dont do this ull face error
            for(int j = 1 ; j <= sum ; j++){
                if(arr[i] <= j){
                    take = dp[i - 1][j - arr[i]];
                }
                noTake = dp[i - 1][j];
                dp[i][j] = take + noTake;
            }
        }
        return dp[n - 1][sum];
    }
    public static int spaceOptimisation(int[] arr, int n, int sum) {
        int[] dp = new int[sum + 1];//in this case we dont need cur and prev as only one is enough

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] += dp[j - arr[i]];
                dp[j] %= MOD; // To avoid overflow, take modulo at each step
            }
        }
        return dp[sum];
    }


}
