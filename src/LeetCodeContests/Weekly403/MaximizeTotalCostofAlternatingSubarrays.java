package LeetCodeContests.Weekly403;

public class MaximizeTotalCostofAlternatingSubarrays {
    public static void main(String[] args) {
        int[] nums = {-14,-13,-20};
        System.out.println(maximumTotalCost(nums));
        System.out.println(tabulation(nums));
    }
    public static long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][][] dp = new long[n][2][2]; //fresh or continue and +Ve or -Ve
        for(int i = 0 ; i <n; i++){
            for(int j = 0 ; j < 2; j++){
                for(int k = 0 ; k < 2; k++){
                    dp[i][j][k] = Long.MAX_VALUE;
                }
            }
        }
        return memo(nums, 0, 0, 0, dp);
    }

    public static long memo(int[] nums, int i, int isFresh, int isPositive, long[][][] dp) {
        // Base case: If we have reached the end of the array, return 0
        if (i == nums.length) return 0;

        // If already computed, return the stored value
        if (dp[i][isFresh][isPositive] != Long.MAX_VALUE) return dp[i][isFresh][isPositive];

        // Initialize variables
        long fresh = Long.MIN_VALUE, cont = Long.MIN_VALUE, ans = Long.MIN_VALUE;

        // If isFresh is 0, we are forced to take nums[i] as a fresh start
        if (isFresh == 0) {
            ans = nums[i] + memo(nums, i + 1, 1, 1, dp);
        } else {
            // We have two sub-cases to consider:
            // Case 1: The sequence was previously negative (isPositive == 0)
            if (isPositive == 0) {
                // Option 1: Start a new fresh sequence (set isFresh to 0)
                fresh = memo(nums, i, 0, 0, dp);
                // Option 2: Continue the sequence by adding the current number
                cont = nums[i] + memo(nums, i + 1, 1, 1, dp);
            } else {
                // Case 2: The sequence was previously positive (isPositive == 1)
                // Option 1: Start a new fresh sequence (set isFresh to 0)
                fresh = memo(nums, i, 0, 0, dp);
                // Option 2: Continue the sequence by flipping the sign of the current number
                cont = (-1 * nums[i]) + memo(nums, i + 1, 1, 0, dp);
            }
        }

        // Store the result in dp array and return it
        return dp[i][isFresh][isPositive] = Math.max(ans, Math.max(fresh, cont));
    }

    public static long tabulation(int[] nums) {
        int n = nums.length;
        long[][][] dp = new long[n][2][2]; // dp[i][j][k]: max total cost starting from index i, with isFresh = j, isPositive = k

        // Initialize dp array with Long.MIN_VALUE (since we want to maximize)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = Long.MIN_VALUE;
                }
            }
        }

        // Base case: Initialize dp values for the last element
        dp[n - 1][0][0] = nums[n - 1];
        dp[n - 1][1][1] = -nums[n - 1];

        // Fill the dp table from right to left
        for (int i = n - 2; i >= 0; i--) {
            for (int isFresh = 0; isFresh < 2; isFresh++) {
                for (int isPositive = 0; isPositive < 2; isPositive++) {
                    long fresh = Long.MIN_VALUE, cont = Long.MIN_VALUE, ans = Long.MIN_VALUE;

                    if (isFresh == 0) {
                        ans = nums[i] + dp[i + 1][1][1];
                    } else {
                        if (isPositive == 0) {
                            fresh = dp[i][0][0];
                            cont = nums[i] + dp[i + 1][1][1];
                        } else {
                            fresh = dp[i][0][0];
                            cont = (-1 * nums[i]) + dp[i + 1][1][0];
                        }
                    }

                    dp[i][isFresh][isPositive] = Math.max(ans, Math.max(fresh, cont));
                }
            }
        }

        return dp[0][0][0];
    }
}
