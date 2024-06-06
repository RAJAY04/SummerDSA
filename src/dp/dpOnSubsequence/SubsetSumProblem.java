package dp.dpOnSubsequence;

import java.util.Arrays;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int N = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(N, arr, sum));
        System.out.println(tabulation(arr,N,sum));
    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        Boolean[][] dp = new Boolean[N][sum + 1];
        return memo(arr, N - 1, sum, dp);
    }

    public static Boolean memo(int[] arr, int n, int sum, Boolean[][] dp) {
        if (sum == 0) return true;
        if (n < 0 || sum < 0) return false;

        if (dp[n][sum] != null) return dp[n][sum];

        boolean exclude = memo(arr, n - 1, sum, dp);

        boolean include = memo(arr, n - 1, sum - arr[n], dp);

        return dp[n][sum] = exclude || include;
    }

    public static Boolean tabulation(int[] arr, int N, int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean exclude = dp[i - 1][j];
                boolean include = (j >= arr[i - 1]) && dp[i - 1][j - arr[i - 1]];

                dp[i][j] = exclude || include;
            }
        }

        return dp[N][sum];
    }

    public static boolean spaceOptimisation(int[] arr, int N, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }
        return dp[sum];
    }


}
