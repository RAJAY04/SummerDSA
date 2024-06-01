package dp.dp1D;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if(n == 1 || n == 0)return 1;
        int prev2 = 1;
        int prev = 1;
        for(int i = 2 ; i <= n; i++){
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
    public static int climbStairs1(int n) {
        if(n == 1 || n == 0)return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1 ;
        dp[1] = 1 ;
        for(int i = 2 ; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
