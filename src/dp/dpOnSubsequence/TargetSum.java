package dp.dpOnSubsequence;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        int n = nums.length;
//        System.out.println(findTargetSumWays(nums,target));
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
}
