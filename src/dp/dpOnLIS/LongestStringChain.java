package dp.dpOnLIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }
    public static int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (checkIsPossible(words[i], words[prev]) && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static boolean checkIsPossible(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == s2.length();
    }
}
