package dp.dpOnStrings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1,s2));
        System.out.println(tabulation(s1,s2));
        System.out.println(spaceOptimisation(s1,s2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1.isEmpty() || text2.isEmpty() ||text1 == null || text2 == null )return 0;
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return memo(text1,text2,n,m,dp);
    }

    public static int memo(String s1,String s2,int i1,int i2,int[][] dp){
        if(i1 == 0 || i2 == 0)return 0;

        if(dp[i1][i2] != -1)return dp[i1][i2];

        if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
            return dp[i1][i2] = 1 + memo(s1,s2,i1 - 1, i2 - 1 , dp);
        }else return dp[i1][i2] = Math.max(memo(s1, s2, i1 - 1, i2, dp), memo(s1, s2, i1, i2 - 1, dp));
    }

    public static int tabulation(String s1,String s2){
        if(s1.isEmpty() || s2.isEmpty() ||s1 == null || s2 == null )return 0;
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        //fill [i][0] & [0][i] with 0 , but its already 0
        for(int i1 = 1; i1 <= n ; i1++){
            for(int i2 = 1; i2 <= m ; i2++){
                if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }else dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);

            }
        }
        return dp[n][m];
    }

    public static int spaceOptimisation(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty() ||s1 == null || s2 == null )return 0;
        int n = s1.length(), m = s2.length();
        int[] cur = new int[m + 1];
        int[] prev = new int[m + 1];
        //fill prev[i] with 0 , but its already 0
        for(int i1 = 1; i1 <= n ; i1++){
            for(int i2 = 1; i2 <= m ; i2++){
                if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
                    cur[i2] = 1 + prev[i2-1];
                }else cur[i2] = Math.max(prev[i2], cur[i2-1]);//Math.max(dp[i1-1][i2], dp[i1][i2-1]) (note that dp[i1][12-1] is cur)

            }
            prev = cur.clone();//make sure to pass the clone and not actual reference
        }
        return prev[m];
    }
}
