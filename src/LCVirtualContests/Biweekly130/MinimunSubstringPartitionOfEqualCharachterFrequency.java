package LCVirtualContests.Biweekly130;

import java.util.Arrays;

public class MinimunSubstringPartitionOfEqualCharachterFrequency {
    public static void main(String[] args) {
        String s = "fabccddg";
        System.out.println(minimumSubstringsInPartition(s));
    }
    static int[] dp;
    static int[][] prefixSum;
    public static int minimumSubstringsInPartition(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
        prefixSum = new int[n][26];
        prefixSum[0][s.charAt(0) - 'a']++;
        for(int i = 1 ; i < n; i++){
            prefixSum[i][s.charAt(i) - 'a']++;
            for(int j = 0 ; j < 26; j++){
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }
        return memo(s,n - 1,dp);

    }
    public static int memo(String s,int i,int[] dp){
        if(i < 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for(int j = i ; j >= 0; j--){
            boolean isPossbile = check(i,j);
            //if !isPossible then proceed further to check for other partitions we may get a valid partition later
            if(!isPossbile){
                continue;
            }
            ans = Math.min(ans,1 + memo(s,j - 1,dp));
        }
        return dp[i] = ans;
    }
    public static boolean check(int i , int j){
        int maxFreq = 0;
        for(int k = 0 ; k < 26; k++){
            int freq = prefixSum[i][k] - (j - 1 >= 0 ? prefixSum[j - 1][k] : 0);
            if(freq > 0){
                if(maxFreq == 0){
                    maxFreq = freq;
                }else if(maxFreq != freq){
                    return false;
                }
            }
        }
        return true;
    }

    public static int minimumSubstringsInPartition1(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int[][] prefixSum = new int[n][26];
        prefixSum[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            System.arraycopy(prefixSum[i - 1], 0, prefixSum[i], 0, 26);
            prefixSum[i][s.charAt(i) - 'a']++;
        }

        return memo(s, n - 1, dp, prefixSum);
    }

    public static int memo(String s, int i, int[] dp, int[][] prefixSum) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int j = i; j >= 0; j--) {
            boolean isPossible = check(s, i, j, prefixSum);
            if (!isPossible) {
                continue;
            }
            ans = Math.min(ans, 1 + memo(s, j - 1, dp, prefixSum));
        }
        return dp[i] = ans;
    }

    public static boolean check(String s, int i, int j, int[][] prefixSum) {
        int maxFreq = 0;
        for (int k = 0; k < 26; k++) {
            int freq = prefixSum[i][k] - (j - 1 >= 0 ? prefixSum[j - 1][k] : 0);
            if (freq > 0) {
                if (maxFreq == 0) {
                    maxFreq = freq;
                } else if (maxFreq != freq) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int tabulation(String s){
        int n = s.length();
        int[] dp = new int[n];
        int[][] prefixSum = new int[n][26];
        prefixSum[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            System.arraycopy(prefixSum[i - 1], 0, prefixSum[i], 0, 26);
            prefixSum[i][s.charAt(i) - 'a']++;
        }
        dp[0] = 1;//if s = 'c' at least 1 substring is there
        for(int i = 1 ; i < n ; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                boolean isPossible = check(s, i, j, prefixSum);
                if (!isPossible) {
                    continue;
                }
                dp[i] = Math.min(dp[i], (j > 0 ? dp[j - 1] : 0) + 1);
            }
        }
        return dp[n - 1];
    }

}
