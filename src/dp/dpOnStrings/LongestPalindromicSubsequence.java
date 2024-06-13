package dp.dpOnStrings;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    //recursive solution would be take dont take pattern or generate all subseq whihc are palindrome and find largest

    //but we can solve this smartly
    //wkt s = rev(s) => palindrome
    //lcs(s) & lcs(rev(s)) => longest palindromic subsequence
    public static int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return spaceOptimisation(s, t);
    }

    public static int spaceOptimisation(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty() ||s1 == null || s2 == null )return 0;
        int n = s1.length(), m = s2.length();
        int[] cur = new int[m + 1];
        int[] prev = new int[m + 1];
        for(int i1 = 1; i1 <= n ; i1++){
            for(int i2 = 1; i2 <= m ; i2++){
                if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
                    cur[i2] = 1 + prev[i2-1];
                }else cur[i2] = Math.max(prev[i2], cur[i2-1]);

            }
            prev = cur.clone();
        }
        return prev[m];
    }
}
