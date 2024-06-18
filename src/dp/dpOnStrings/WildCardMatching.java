package dp.dpOnStrings;

public class WildCardMatching {
    public static void main(String[] args) {
        String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
        String p = "*aabb***aa**a******aa*";//this test case gives tle for memo
//        boolean result = isMatch(s, p);
//        System.out.println("The result is: " + result);
        boolean result1 = tabulation(s, p);
        System.out.println("The result is: " + result1);
        boolean result2 = spaceOptimisation(s, p);
        System.out.println("The result is: " + result2);
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length() , m = p.length();
        Boolean[][] dp = new Boolean[n  + 1][m + 1];
        return memo(s,p,n,m,dp);
    }

    public static boolean memo(String s1, String s2, int n , int m , Boolean[][] dp){
        if(n == 0 && m == 0)return true;
        if(n == 0 && m > 0){
            for(int i = 0 ; i < m; i++){
                if(s2.charAt(i) != '*')return false;
            }
            return true;
        }
        if(n > 0 && m == 0)return false;

        if (s2.charAt(m - 1) == '*') {
            dp[n][m] = memo(s1, s2, n - 1, m, dp) || memo(s1, s2, n, m - 1, dp);
        } else if (s2.charAt(m - 1) == '?' || s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = memo(s1, s2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = false;
        }

        return dp[n][m];
    }

    public static boolean tabulation(String s1, String s2){
        int n = s1.length(), m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (s2.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s2.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (s2.charAt(j - 1) == '?' || s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static boolean spaceOptimisation(String s1,String s2){
        int n = s1.length(), m = s2.length();
        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];

        // Base case: empty string and empty pattern are a match
        prev[0] = true;

        // Base case: pattern with '*' can match an empty string
        for (int j = 1; j <= m; j++) {
            if (s2.charAt(j - 1) == '*') {
                prev[j] = prev[j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = false; // Only an empty pattern can match an empty string
            for (int j = 1; j <= m; j++) {
                if (s2.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else if (s2.charAt(j - 1) == '?' || s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            // Move the current row to the previous row for the next iteration
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }
}
