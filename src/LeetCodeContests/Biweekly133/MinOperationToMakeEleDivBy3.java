package LeetCodeContests.Biweekly133;

public class MinOperationToMakeEleDivBy3 {
    public static void main(String[] args) {

    }
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 3 == 2)ans += 1;
            else ans += nums[i] % 3;
        }
        return ans;
    }
}
