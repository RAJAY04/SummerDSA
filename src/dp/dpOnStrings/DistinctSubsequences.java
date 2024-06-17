package dp.dpOnStrings;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s,t));
        System.out.println(tabulation(s,t));
    }
    public static int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);

        return memo(s,t,n,m,dp);
    }

    public static int memo(String s, String t, int n ,int m , int[][] dp){
        if(n == 0 || m == 0){
            if(m != 0)return 0;
            else return 1;
        }

        if(dp[n][m] != -1)return dp[n][m];

        int take = 0, noTake = 0;

        if(s.charAt(n - 1) == t.charAt(m - 1)){
            take = memo(s,t,n - 1, m - 1,dp);
        }
        noTake = memo(s,t,n - 1, m ,dp);
        //this can be done in two ways
        //if we are using if else then we should do
        //take = memo(s,t,n - 1, m - 1,dp) + memo(s,t,n - 1, m ,dp); because even if we take a index, we should check for not take too in m/t
        //else noTake = memo(s,t,n - 1, m ,dp);
        return dp[n][m] = take + noTake;
    }

    public static int tabulation(String s, String t){
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n ;i++){
            for(int j = 1; j <= m ;j++){
                int take = 0, noTake = 0;

                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    take = dp[i - 1][j - 1];
                }
                noTake = dp[i - 1][j];
                dp[i][j] = take + noTake;
            }
        }
        return dp[n][m];
    }

    public static int spaceOptimisation(String s, String t){
        int n = s.length(), m = t.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] newDp = new int[m + 1];
            newDp[0] = 1;
            for (int j = 1; j <= m; j++) {
                int take = 0, noTake = 0;

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    take = dp[j - 1];
                }
                noTake = dp[j];
                newDp[j] = take + noTake;
            }

            dp = newDp;
        }
        return dp[m];
    }
}
