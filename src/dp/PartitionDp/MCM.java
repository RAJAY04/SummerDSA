package dp.PartitionDp;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        System.out.println(matrixMultiplication(arr.length,arr));
        System.out.println(tabulation(arr,arr.length));
    }
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        for(int[] nums : dp){
            Arrays.fill(nums,-1);
        }
        return mcm(arr,1,N - 1,dp);
    }

    static int mcm(int[] arr, int i , int j, int[][] dp){
        if(i == j)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int minSteps = Integer.MAX_VALUE;

        for(int k = i; k < j ; k++){
            int steps = (arr[i - 1] * arr[k] * arr[j]) + mcm(arr,i,k,dp) + mcm(arr,k + 1, j,dp);
            minSteps = Math.min(steps,minSteps);
        }
        return dp[i][j] = minSteps;

    }

    public static int tabulation(int[] arr , int n){
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
