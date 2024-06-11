package dp.dpOnSubsequence;

import java.util.Arrays;
//this is same as unbounded knapsac say n = 8 => wt = {1,2,3,4,5,6,7,8} :)
public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(cutRod(price,n));
    }
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        int index = n - 1;
        return memo(price,index,n,dp);
    }

    public static int memo(int[] val, int n , int cost, int[][] dp){
        if(cost == 0)return 0;
        if(n == 0){
            return (cost) * val[0];
        }
        if(dp[n][cost] != -1)return dp[n][cost];
        int pick = 0 , noPick = 0;
        noPick = memo(val,n - 1, cost,dp);
        if(n + 1 <= cost){
            pick = memo(val, n , cost - (n + 1) ,dp) + val[n];
        }

        return dp[n][cost] = Math.max(pick,noPick);

    }

    public static int cutRodTabulation(int[] price, int n) {
        int[][] dp = new int[n][n + 1];

        // Initialize the dp array
        for (int length = 0; length <= n; length++) {
            dp[0][length] = length * price[0];
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int length = 0; length <= n; length++) {
                int noPick = dp[i - 1][length];
                int pick = Integer.MIN_VALUE;
                if (i + 1 <= length) {
                    pick = dp[i][length - (i + 1)] + price[i];
                }
                dp[i][length] = Math.max(pick, noPick);
            }
        }

        return dp[n - 1][n];
    }

    public static int cutRodSpaceOptimisation(int[] price, int n) {
        int[] dp = new int[n + 1];

        // Initialize the dp array
        for (int length = 0; length <= n; length++) {
            dp[length] = length * price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int length = 0; length <= n; length++) {
                int pick = Integer.MIN_VALUE;
                if (i + 1 <= length) {
                    pick = dp[length - (i + 1)] + price[i];
                }
                dp[length] = Math.max(dp[length], pick);
            }
        }

        return dp[n];
    }

}
