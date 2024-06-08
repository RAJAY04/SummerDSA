package dp.dpOnSubsequence;

import java.util.Arrays;

public class KnapsacProblem {
    public static void main(String[] args) {
        int[] val = {1,2,3};
        int[] wt = {4,5,1};
        int W = 4;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(tabulation(val,wt,W,n));
        System.out.println(spaceOptimisation(val,wt,W,n));
    }
    public static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n][W + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return memo(val,wt,n - 1 ,W,dp);
    }
    public static int memo(int[] val, int[] wt, int n , int w,int[][] dp){
        if(n == 0){
            return (wt[0] <= w) ? val[0] : 0;
        }


        if(dp[n][w] != -1)return dp[n][w];

        int take = 0, dontTake = 0;
        if(wt[n] <= w){
            take = val[n] + memo(val,wt,n - 1, w - wt[n], dp);
        }
        dontTake = memo(val,wt, n - 1, w , dp);
        return dp[n][w] = Math.max(take ,dontTake);
    }

    public static int tabulation(int[] val , int[] wt, int w, int n){
        int[][] dp = new int[n][w + 1];
        for(int i = wt[0] ; i <= w ; i++){
            dp[0][i] = val[0];
        }

        for(int i = 1; i < n ;i++){
            int take = 0, noTake = 0;
            for(int j = 0 ; j <= w ; j++){
                if(j >= wt[i]){
                    take = dp[i - 1][j - wt[i]] + val[i];
                }
                noTake = dp[i - 1][j];
                dp[i][j] = Math.max(take,noTake);
            }
        }
        return dp[n - 1][w];

    }
    public static int spaceOptimisation(int[] val , int[] wt, int w, int n){
        int[]dp = new int[w + 1];
        for(int i = wt[0] ; i <= w ; i++){
            dp[i] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = w; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);//sweet and simple
            }
        }
        return dp[w];

    }
}
