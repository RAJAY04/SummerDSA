package dp.dpOnSubsequence;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,1};
        int target = 1;
        int n = nums.length;
//        System.out.println(findTargetSumWays(nums,target));
        System.out.println(findTargetSumWays(nums,1));
        System.out.println(tabulation(nums,target));
        System.out.println(spaceOptimisation(nums,target));
    }
//did the recursion by myself, but no dp as target can be negative too so saw the lecture.
//    public static int findTargetSumWays1(int[] nums ,int target) {
//        //THIS APPROACH IS FINE BUT HARD TO MEMOISE CZ
//        OF NEGATIVE VALUES, WE HAVE TO TAKE DP OF SIZE [N][TOTAL_ARRAY_SIZE * 2 + 1]
//        //SO FOLLOW STRIVERS APPROACH S1-S2 = D PATTERN.
//        int n = nums.length;
//        return memo1(nums,n - 1,target);
//    }
//    public static int memo1(int[] nums, int n ,int target){
//        if(n == 0){
//            if(nums[0] == 0 && target == 0)return 2;//very imp to handle 0 in base case
//            if((target - nums[0] == 0)|| (target + nums[0] == 0))return 1;
//            else return 0;
//        }
//        int pos = 0 , neg = 0;
//        pos = memo(nums,n - 1, target + nums[n]);
//        neg = memo(nums, n - 1, target - nums[n]);
//        return pos + neg;
//    }

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums)sum += num;
        if(sum - target < 0)return 0;//edge case
        int s = sum - target;
        if(s % 2 == 1)return 0;
        int[][] dp = new int[n][s + 1];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return memo(nums, n - 1, s/2, dp);
    }
    public static int memo(int[] nums,int n , int target, int[][] dp){
        if(n == 0){
            if(target == 0 && nums[0] == 0)return 2;
            if(target == 0)return 1;
            if(target == nums[0])return 1;
            else return 0;
        }

        if(dp[n][target] != -1)return dp[n][target];

        int pick = 0 , noPick = 0;
        if(nums[n] <= target){
            pick = memo(nums, n - 1, target - nums[n],dp);
        }
        noPick = memo(nums, n - 1, target, dp);
        return dp[n][target] = pick + noPick;
    }

    public static int tabulation(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        // Fix the modulo operation check
        if ((sum - target) < 0 || (sum - target) % 2 != 0) return 0;

        int s = (sum - target) / 2;
        int[][] dp = new int[n][s + 1];

        // Initialize dp[0][0] correctly based on nums[0]
        if (nums[0] == 0) {
            dp[0][0] = 2; // 2 cases - pick and not pick
        } else {
            dp[0][0] = 1; // 1 case - not pick
            if (nums[0] <= s) dp[0][nums[0]] = 1; // 1 case - pick
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= s; j++) {
                int pick = 0;
                int noPick = dp[i - 1][j]; // No pick case

                // Pick case
                if (nums[i] <= j) {
                    pick = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = pick + noPick;
            }
        }

        return dp[n - 1][s];
    }
    public static int spaceOptimisation(int[] nums,int target){
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        // Fix the modulo operation check
        if ((sum - target) < 0 || (sum - target) % 2 != 0) return 0;

        int s = (sum - target) / 2;
        int[] dp = new int[s + 1];


        // Initialize dp[0][0] correctly based on nums[0]
        if (nums[0] == 0) {
            dp[0] = 2; // 2 cases - pick and not pick
        } else {
            dp[0] = 1; // 1 case - not pick
            if (nums[0] <= s) dp[nums[0]] = 1; // 1 case - pick
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            int[] cur = new int[s + 1];
            for (int j = 0; j <= s; j++) {
                int pick = 0;
                int noPick = dp[j]; // No pick case

                // Pick case
                if (nums[i] <= j) {
                    pick = dp[j - nums[i]];
                }
                cur[j] = pick + noPick;
            }
            dp = cur;
        }

        return dp[s];
    }
}
