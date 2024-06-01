package dp.dp1D;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30 ,10};
        Integer[] dp = new Integer[arr.length];
        System.out.println(dfs(arr,arr.length - 1,dp));
        System.out.println(frogJump(arr,arr.length - 1,dp));
        System.out.println(minimumEnergy(arr,arr.length));
    }


    public static int dfs(int[] arr,int i,Integer[] dp){//even with memoization gives stack overflow
        if(i == 0){
            return 0;
        }
        if(dp[i] != null)return dp[i];
        int one = dfs(arr,i - 1,dp) + Math.abs(arr[i] - arr[i - 1]);
        int two = Integer.MAX_VALUE;
        if(i > 1){
            two = dfs(arr,i - 2,dp) + Math.abs(arr[i] - arr[i - 2]);
        }
        return dp[i] = Math.min(one ,two);
    }

    public static int frogJump(int[] arr, int n , Integer[] dp){//tabulation
        dp[0] = 0;
        for(int i = 1; i < n ; i++){
            dp[i] = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            if(i > 1){
                dp[i] = Math.min(dp[i],dp[i - 2] + Math.abs(arr[i] - arr[i - 2]));
            }
        }
        return dp[n - 1];
    }
    public static int minimumEnergy(int[] arr,int N){//space optimaizaton
        int prev = 0, prev2 = 0, cur = 0;
        for(int i = 1; i < N ; i++){
            cur = prev + Math.abs(arr[i] - arr[i - 1]);
            if(i > 1){
                cur = Math.min(cur,prev2 + Math.abs(arr[i] - arr[i - 2]));
            }
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

}
