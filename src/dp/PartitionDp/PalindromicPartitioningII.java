package dp.PartitionDp;

import java.util.Arrays;

public class PalindromicPartitioningII {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(minCut(s));
        System.out.println(tabulation(s));
    }
    public static int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return memo(s,0,dp);
    }
    public static int memo(String s, int i, int[] dp){
        if (i == s.length()) return 0;
        if (dp[i] != -1) return dp[i];

        if (isPalindrome(s, i, s.length() - 1)) {
            // If the entire substring from i to the end is a palindrome, no cuts are needed
            return dp[i] = 0;
        }

        int min = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                if (j + 1 == s.length() || isPalindrome(s, j + 1, s.length() - 1)) {
                    // If the right portion is fully a palindrome, we need only one cut
                    min = 1;
                    break;
                }
                int ans = 1 + memo(s, j + 1, dp);
                min = Math.min(ans, min);
            }
        }
        return dp[i] = min;
    }
    public static boolean isPalindrome(String s, int i , int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }


    //public static int memo(String s, int i, int[] dp){   this code works properly no need to check explicitely if the right portion is a palindrome or s itself is a palindrome or s is of len 1
    //        if (i == s.length()) return 0;
    //
    //        if (dp[i] != -1) return dp[i];
    //        int min = Integer.MAX_VALUE;
    //        for (int j = i; j < s.length(); j++) {
    //            if (isPalindrome(s, i, j)) {
    //                if (j + 1 == s.length()) {
    //                    // If the entire right portion is a palindrome, no further cuts are needed
    //                    return dp[i] = 0;
    //                }
    //                int ans = 1 + memo(s, j + 1, dp);
    //                min = Math.min(ans, min);
    //            }
    //        }
    //        return dp[i] = min;
    //    }


    public static int tabulation(String s){
        int n = s.length();
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j + 1 == n) {
                        min = 0; // If the entire substring from i to the end is a palindrome, no cuts are needed
                    } else {
                        int ans = 1 + dp[j + 1];
                        min = Math.min(ans, min);
                    }
                }
            }
            dp[i] = min;
        }

        return dp[0];
    }
}
