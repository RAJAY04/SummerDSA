package dp.dpOnSubsequence;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins,amount));
        System.out.println(tabulation(coins,amount));
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0)return 0;
        int[][] dp = new int[n][amount + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        int ans =  memo(coins,amount,n - 1, dp);
        if(ans == 10000000)return -1;
        return ans;
    }
    public static int memo(int[] coins, int amount, int n , int[][] dp){
        if(amount == 0)return 0;
        if(n == 0)return (amount % coins[n] == 0) ? amount / coins[n] : 10000000;

        if(dp[n][amount] != -1)return dp[n][amount];

        int take = 10000000 , notake = 0;
        if(coins[n] <= amount)
            take = 1 + memo(coins,amount - coins[n] , n , dp);
        notake = memo(coins,amount,n - 1,dp);

        return dp[n][amount] = Math.min(take , notake);
    }
    public static int tabulation(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0 ; i <= amount; i++){
            if(i % coins[0] == 0)dp[0][i] = i / coins[0];
            else dp[0][i] = 10000000;
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j <= amount ; j++){
                int take = 10000000 , notake = 0;
                if(coins[i] <= j)
                    take = 1 + dp[i][j - coins[i]];
                notake = dp[i - 1][j];
                dp[i][j] = Math.min(take , notake);
            }
        }
        if(dp[n - 1][amount] >= 10000000)return -1;
        else return dp[n - 1][amount];
    }

    public static int spaceOptimisation(int[] coins, int amount){
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for(int i = 1 ; i <= amount ; i++){
            if(i % coins[0] == 0)dp[i] = i / coins[0];
            else dp[i] = 10000000;
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j <= amount ; j++){
                int take = 10000000 , notake = 0;
                if(coins[i] <= j)
                    take = 1 + dp[j - coins[i]];
                notake = dp[j];
                dp[j] = Math.min(take , notake);
            }
        }
        if(dp[amount] >= 10000000)return -1;
        else return dp[amount];
    }
}
