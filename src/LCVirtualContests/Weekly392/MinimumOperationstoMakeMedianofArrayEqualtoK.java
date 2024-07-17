package LCVirtualContests.Weekly392;

import java.util.Arrays;

public class MinimumOperationstoMakeMedianofArrayEqualtoK {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 4;
        System.out.println(minOperationsToMakeMedianK(nums, k));
    }
    public static long minOperationsToMakeMedianK(int[] nums, int k) {
        long res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int medianIndex = n / 2;

        if(k < nums[medianIndex]){
            for(int i = 0 ;i <= medianIndex; i++){
                if(nums[i] > k){
                    res += Math.abs(k - nums[i]);
                }
            }
        }else{
            for(int i = n - 1; i >= medianIndex ;i--){
                if(nums[i] < k){
                    res += Math.abs(k - nums[i]);
                }
            }
        }
        return res;
    }
}
