package Extras;

import java.util.*;

public class MinimumTime {
    public static void main(String[] args) {
        int n = 4;
        List<Integer> time = Arrays.asList(3,1,8,7);
        List<Integer> search = Arrays.asList(4,4,6,2);
        int k = 2;
        System.out.println(minTime(n, time, search, k));
        System.out.println(tabulation(n, time, search, k));
    }

    public static int solver(int i, List<Integer> time, List<Integer> search, int k, int[] dp) {
        int n = time.size();
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int c1 = time.get(i) + solver(i + 1, time, search, k, dp);
        int c2 =  Integer.MAX_VALUE;

        for(int j = 1 ; j <= Math.min(k,n - i) ; j++){
            c2 = Math.min(c2,search.get(i) + solver(i + j, time, search, k, dp));
        }
        dp[i] = Math.min(c1, c2);
        return dp[i];
    }

    public static int minTime(int n, List<Integer> time, List<Integer> search, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solver(0, time, search, k,dp);
    }

    public static int tabulation(int n, List<Integer> time, List<Integer> search, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int c1 = time.get(i) + dp[i + 1];
            int c2 = Integer.MAX_VALUE;

            for (int j = 1; j <= Math.min(k, n - i); j++) {
                c2 = Math.min(c2, search.get(i) + dp[i + j]);
            }
            dp[i] = Math.min(c1, c2);
        }

        return dp[0];
    }



}