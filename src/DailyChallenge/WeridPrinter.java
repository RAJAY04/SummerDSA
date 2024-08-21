package DailyChallenge;

import java.util.Arrays;

public class WeridPrinter {
    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(strangePrinter(s));
    }
    public static int memo(int i , int j , char[] s,int[][] dp){
        if(i == j)return 1;

        if(dp[i][j] != -1)return dp[i][j];

        int minTurns = Integer.MAX_VALUE;

        for(int k = i ; k < j ; k++){
            minTurns = Math.min(memo(i,k,s,dp) + memo(k + 1,j,s,dp) , minTurns);
        }
        return dp[i][j] = (s[i] == s[j]) ? minTurns - 1: minTurns;
    }
    public static int strangePrinter(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int[] temp : dp){
            Arrays.fill(temp,-1);
        }

        return memo(0,n - 1, arr, dp);
    }
}
