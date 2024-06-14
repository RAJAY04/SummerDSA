package dp.dpOnStrings;

import java.util.Arrays;

public class MinInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {
        //this qn can be rephrased as min deletions to make the string palindrome, as
        //say aabcaa here we have to take part which isnot a palindrome say b or c, and reverse and put in required place
        //we know the trick to find LPalindormicS by using LCS
        //we can also find LPS by expanding out method used in neetcode.
        //our ans = Math.abs(len - LPS)
        //min del or insertion( as we find non palindromic thing and stuff it in)

        //bonous tip : take a pointer on first and last position and expand inwards, it saves us running loop on all characters
        //even solves problem of odd or even too
        String s = "mbadm";
        System.out.println(minInsertions(s));

    }
    public static int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return Math.abs(longestPalindromicSubsequence(s,0,len - 1,dp)- len);

    }

    //this is neetcodes method to find LPS directly without having to reverse ans pass the sting to LCS
    public static int longestPalindromicSubsequence(String s,int i , int j,int[][] dp){
        if(i == j)return 1;
        if(i > j) return 0;
        if(dp[i][j] != -1)return dp[i][j];

        int max = 0;
        boolean match = s.charAt(i) == s.charAt(j);
        if(match){
            return dp[i][j] = 2 + longestPalindromicSubsequence(s,i + 1, j - 1 , dp);
        }else return dp[i][j] = Math.max(longestPalindromicSubsequence(s,i + 1, j , dp),longestPalindromicSubsequence(s,i, j - 1, dp));
    }
    //tabulation and space optimisation find out how its done, felt hard to understand
}
