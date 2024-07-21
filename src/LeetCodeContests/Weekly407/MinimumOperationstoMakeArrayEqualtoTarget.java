package LeetCodeContests.Weekly407;

public class MinimumOperationstoMakeArrayEqualtoTarget {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int[] target = {9,4,2};
        System.out.println(minimumOperations(nums, target));
    }

    public static long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] diff = new int[n];
        for(int i = 0 ; i < n ; i++){
            diff[i] = target[i] - nums[i];
        }
        long ans = 0;
        int  incBar = 0, decBar = 0;
        for(int i = 0 ; i < n ;i++){
            if(diff[i] > 0){
                if(incBar < diff[i]){
                    int extra = (diff[i] - incBar);
                    ans += extra;
                }
                incBar = diff[i];
                decBar = 0;
            }else if(diff[i] < 0){
                if(decBar < -diff[i]){
                    int extra = (-diff[i] - decBar);
                    ans += extra;
                }
                decBar = -diff[i];
                incBar = 0;
            }else incBar = decBar = 0;

        }
        return ans;
    }
}
