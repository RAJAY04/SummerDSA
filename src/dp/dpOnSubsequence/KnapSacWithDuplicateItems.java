package dp.dpOnSubsequence;

import java.util.Arrays;

public class KnapSacWithDuplicateItems {
    public static void main(String[] args) {
        int N = 2;
        int W = 3;
        int val[] = {1,1};
        int wt[] = {2,1};
        System.out.println(knapSack(N, W, val, wt));
        System.out.println(tabulation(val,wt,W,N));
        System.out.println(spaceOptimisation(val,wt,W,N));

    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N][W+1];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return memo(val,wt,N - 1,W,dp);
    }

    public static int memo(int[] val, int[] wt,int n , int w, int[][] dp){
        if(n == 0){
            return (w / wt[0]) * val[0];
        }//note that we should not take modulo because of test case wt = {2} val = {10} w = 5;
        if(w == 0)return 0;
        if(n < 0)return Integer.MIN_VALUE;

        if(dp[n][w] != -1)return dp[n][w];
        int pick = 0 , noPick = 0;
        noPick = memo(val,wt,n - 1, w,dp);
        if(wt[n] <= w){
            pick = memo(val,wt, n , w - wt[n] ,dp) + val[n];
        }

        return dp[n][w] = Math.max(pick,noPick);

    }

    public static int tabulation(int[]val, int[] wt, int w, int n){
        int[][] dp = new int[n][w+1];
        for(int i = 0 ; i <= w ; i++){
            dp[0][i] = (i / wt[0]) * val[0];
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j <= w; j++){
                int pick = 0;
                int noPick = dp[i - 1][j];
                if(wt[i] <= j){
                    pick =dp[i][j - wt[i]] + val[i];
                }

                dp[i][j] = Math.max(pick,noPick);
            }
        }
        return dp[n - 1][w];
    }

    public static int spaceOptimisation(int[]val, int[] wt, int w, int n){
        int[] dp = new int[w+1];
        for (int i = wt[0]; i <= w; i++) {
            dp[i] = (i / wt[0]) * val[0];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=w; j++) {//should go from 0 to w itelsf
                int pick = 0;
                if (wt[i] <= j) {
                    pick = dp[j - wt[i]] + val[i];
                }
                int noPick = dp[j];
                dp[j] = Math.max(noPick, pick);
            }
        }
        return dp[w];
    }
}
