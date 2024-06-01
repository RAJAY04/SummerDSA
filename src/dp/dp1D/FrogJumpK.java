package dp.dp1D;

public class FrogJumpK {
    public static void main(String[] args) {
        int[] arr = {10, 30, 40, 50, 20};
        Integer[] dp = new Integer[arr.length];

        System.out.println(dfs(arr,arr.length - 1,dp,3));
        System.out.println(minimizeCost(arr,arr.length - 1, 3));
    }
    public static int dfs(int[] arr, int n , Integer[] dp, int k){
        if(n == 0){
            return 0;
        }
        if(dp[n] != null)return dp[n];
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= Math.min(k,n) ; i++){
            ans = dfs(arr,n - i,dp,k) + Math.abs(arr[n] - arr[n - i]);
            min = Math.min(min,ans);
        }
        return dp[n] = min;
    }
    public static int minimizeCost(int[] arr,int N,int K){
        int[] dp = new int[N];
        dp[0] = 0;
        int min = 0;
        for(int i = 1 ; i < N; i++){
            min = Integer.MAX_VALUE;
            for(int j = 1 ; j <= Math.min(K,i) ; j++){
                dp[i] = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                min = Math.min(min,dp[i]);
            }
            dp[i] = min;//missed this step, use common sence and general observation
        }
        return dp[N - 1] = min;
    }
}
