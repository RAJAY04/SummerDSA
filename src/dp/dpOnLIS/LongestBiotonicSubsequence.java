package dp.dpOnLIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestBiotonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(LongestBitonicSequence(nums.length,nums));
    }
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];


        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && dp1[prev] + 1 > dp1[i]) {
                    dp1[i] = dp1[prev] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int prev = n - 1; prev > i; prev--) {
                if (nums[i] > nums[prev] && dp2[prev] + 1 > dp2[i]) {
                    dp2[i] = dp2[prev] + 1;
                }
            }
        }
        int len = 0;

        for(int i = 0 ; i < n ; i++){
            if(dp1[i] > 1 && dp2[i] > 1)//this is to handle the cases when array is stricly increasing or decreasing which is not a monotonic array
                //it works because in that case dp1[i] or dp2[i] will be 1
                len = Math.max(len,dp1[i]+dp2[i] - 1);
        }
        return len;
    }

}
