package dp.PartitionDp;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr,k));
        System.out.println(tabulation(arr,k));
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return memo(arr,0,k,dp);
    }
    public static int memo(int[] arr ,int i ,int k ,int[] dp){
        if(i == arr.length)return 0;

        if(dp[i] != -1)return dp[i];
        int maxEle = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE, sum = 0,len = 0;
        for(int j = i ; j < Math.min(arr.length,i + k); j++){
            len++;
            maxEle = Math.max(maxEle,arr[j]);
            sum = (len * maxEle) + memo(arr,j + 1 , k , dp);
            maxAns = Math.max(maxAns,sum);
        }
        return dp[i] = maxAns;
    }

    public static int tabulation(int[] arr, int k){
        int n = arr.length;
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0 ; i--){
            int maxEle = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE, sum = 0,len = 0;
            for(int j = i ; j < Math.min(arr.length,i + k); j++){
                len++;
                maxEle = Math.max(maxEle,arr[j]);
                sum = (len * maxEle) + dp[j + 1];
                maxAns = Math.max(maxAns,sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}
