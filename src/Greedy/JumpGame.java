package Greedy;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1 ;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] >= goal - i){
                goal = i;

            }
        }
        return nums[0] >= goal;
    }
}
