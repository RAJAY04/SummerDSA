package dp.PartitionDp;

import java.util.Arrays;

public class MinimumCostToCutSticks {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        System.out.println(minCost(7,arr));
        System.out.println(tabulation(arr,7));
    }

    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int newN = cuts.length + 2;
        int[] newCuts = new int[newN];

        for(int i = 1; i <= cuts.length; i++){
            newCuts[i] = cuts[i - 1];
        }
        newCuts[0] = 0;
        newCuts[newN - 1] = n;
        int[][] dp = new int[newN][newN];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return memo(newCuts,1,newN - 2,dp);
    }
    public static int memo(int[] cuts,int i ,int j, int[][] dp){
        if(j < i)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int cost = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int curCost = (cuts[j + 1] - cuts[i - 1]) + memo(cuts,i,k - 1,dp) + memo(cuts,k + 1,j,dp);
            cost = Math.min(cost,curCost);
        }
        return dp[i][j] = cost;
    }

    public static int tabulation(int[] cuts,int n){
        Arrays.sort(cuts);
        int newN = cuts.length + 2;
        int[] newCuts = new int[newN];

        for(int i = 1; i <= cuts.length; i++){
            newCuts[i] = cuts[i - 1];
        }
        newCuts[0] = 0;
        newCuts[newN - 1] = n;
        int[][] dp = new int[newN + 1][newN + 1];

        for(int i = newN - 2 ;i >= 1; i--){
            for(int j = 1 ; j <= newN - 2; j++){//just the reverse of what we did in tabulation
                int cost = Integer.MAX_VALUE;
                if(i > j )continue;
                for(int k = i; k <= j; k++){
                    int curCost = (newCuts[j + 1] - newCuts[i - 1]) + dp[i][k - 1] + dp[k + 1][j];
                    cost = Math.min(cost,curCost);
                }
                dp[i][j] = cost;
            }
        }
        return dp[1][newN - 2];
    }
}
