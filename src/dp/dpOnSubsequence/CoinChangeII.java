package dp.dpOnSubsequence;

import javax.naming.PartialResultException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(amount,coins));
        System.out.println(tabulation(coins,amount));
        System.out.println(spaceOptimisation(coins,amount));

    }
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return memo(coins,n - 1,amount,dp);
    }
    public static int memo(int[] nums , int n , int target, int[][] dp){
        if(target == 0)return 1;
        if(n == 0){
            return target % nums[0] == 0 ? 1 : 0;
        }
        if( n < 0)return 0;

        if(dp[n][target]  != -1)return dp[n][target];

        int pick = 0 , noPick = 0;

        if(target >= nums[n]){
            pick = memo(nums,n , target - nums[n],dp);
        }
        noPick = memo(nums,n - 1, target,dp);
        return  dp[n][target] = pick + noPick;
    }
    public static int tabulation(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }

        for(int i = 1 ; i < n ;i++){
            int pick = 0 , noPick = 0;
            for(int j = 0 ; j <= amount; j++){
                if(j >= coins[i]){
                    pick = dp[i][j -coins[i]] ;
                }
                noPick = dp[i - 1][j];
                dp[i][j] = pick + noPick;
            }
        }
        return dp[n - 1][amount];
    }
    public static int spaceOptimisation(int[] coins, int amount){
        int n = coins.length;
        int[] prev = new int[amount + 1];

        prev[0] = 1;

        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                prev[j] = 1;
            }
        }

        for(int i = 1 ; i < n ;i++){
            int[] cur = new int[amount + 1];
            int pick = 0 , noPick = 0;
            for(int j = 0 ; j <= amount; j++){
                if(j >= coins[i]){
                    pick = cur[j - coins[i]] ;//note this is cur array as we do memo(arr, n,) we dont change
                }
                noPick = prev[j];
                cur[j] = pick + noPick;
            }
            prev = cur;
        }
        return prev[amount];
    }
}
