package Greedy;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(jump(nums));
        System.out.println(tabulation(nums));
        System.out.println(greedy(nums));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memo(nums, 0, dp);
    }

    public static int memo(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length - 1) {
            return 0;
        }

        if (dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < nums.length) {
                int subResult = memo(nums, idx + i, dp);
                if (subResult != Integer.MAX_VALUE) {
                    ans = Math.min(ans, subResult + 1);
                }
            }
        }

        return dp[idx] = ans;
    }

    public static int tabulation(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for(int idx = n - 2 ; idx >= 0; idx--){
            int maxJump = Math.min(n - 1,idx + nums[idx]);
            for(int jump = idx + 1; jump <= maxJump; jump++){
                if (dp[jump] != Integer.MAX_VALUE) {
                    dp[idx] = Math.min(dp[idx], dp[jump] + 1);
                }
            }
        }
        return dp[0];
    }

    public static int greedy(int[] nums){//converting a recursive solution into range based
        int goal = nums.length - 1;
        if (goal == 0) return 0;

        int s = 1, e = nums[0], jump = 1;

        // If the initial end already reaches or exceeds the goal
        if (e >= goal) return jump;

        while (e < goal) {
            int newEnd = e;
            for (int i = s; i <= e; i++) {
                newEnd = Math.max(nums[i] + i, newEnd);
            }

            // Move the start of the new range to the end of the previous range
            s = e + 1;
            // Update the end of the current range to newEnd
            e = newEnd;

            // Increment jump count
            jump++;

            // If the newEnd reaches or exceeds the goal
            if (e >= goal) break;
        }

        return jump;
    }
}
