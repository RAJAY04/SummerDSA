package dp.dpOnStrings;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String S1 = "ABCDGH";
        String S2 = "ACDGHR";
        int n = S1.length();
        int m = S2.length();
        System.out.println(longestCommonSubstr(S1, S2));
        System.out.println(tabulation(S1,S2));
        System.out.println(spaceOptimisation(S1,S2));
    }

    public static int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Call the recursive function with initial parameters
        return lcs(s1, s2, m, n, 0);
    }

    // Recursive function to find the length of the longest common substring
    private static int lcs(String s1, String s2, int m, int n, int count) {
        // Base case: If either string is empty, return the current count
        if (m == 0 || n == 0) {
            return count;
        }

        // If characters match, recursively compute for the substring excluding these characters
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            count = lcs(s1, s2, m - 1, n - 1, count + 1);
        } else {
            // If characters do not match, take the maximum length between excluding one character from s1 or s2
            count = Math.max(count, Math.max(
                    lcs(s1, s2, m - 1, n, 0),
                    lcs(s1, s2, m, n - 1, 0)
            ));
        }

        return count;
    }//dont memoise cz it will take 3 state changes

    public static int tabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }else dp[i][j] = 0;
            }
        }
        return ans;
    }

    public static int spaceOptimisation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int[] cur = new int[m + 1];
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    cur[j] = dp[j - 1] + 1;
                    ans = Math.max(cur[j], ans);
                }else cur[j] = 0;
            }
            dp = cur.clone();
        }
        return ans;
    }

}
