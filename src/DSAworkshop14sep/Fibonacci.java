package DSAworkshop14sep;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 46;
//        System.out.println(recursion(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        System.out.println(memo(n,dp));
        System.out.println(tabulation(n));
        System.out.println(spaceOptimisation(n));
        System.out.println(Math(n));
    }
    // 0 1 1 2 3 5 8 13 21 34
    public static int recursion(int n){
        if(n <= 1)return n;
        return recursion(n - 1) + recursion(n - 2);
        //space complexity O(n)
        //time complexity O(2^n)
    }

    public static int memo(int n,int[] dp){
        if(n <= 1)return n;
        if(dp[n] != -1)return dp[n];
        return dp[n] = memo(n - 1,dp) + memo(n - 2,dp);
        //space complexity O(n) + O(n)
        //time complexity O(n)
    }

    public static int tabulation(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        //space complexity O(n)
        //time complexity O(n)
    }

    public static int spaceOptimisation(int n){
        int prev = 1, superPrev = 0;
        int cur = 0;

        for(int i = 2; i <= n; i++){
            cur = prev + superPrev;
            superPrev = prev;
            prev = cur;
        }
        return prev;
        //space complexity O(1)
        //time complexity O(n)
    }
    //space optimisation is the most optimal dp solution one can give

    public static int Math(int n){
        double phi = (1 + Math.sqrt(5)) / 2;
        double fib = (Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5);
        return (int) Math.round(fib);
        //space complexity O(1)
        //time complexity O(1)
    }
}
