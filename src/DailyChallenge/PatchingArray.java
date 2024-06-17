package DailyChallenge;

public class PatchingArray {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int n = 6;
        System.out.println(minPatches(nums, n));
    }
    public static int minPatches(int[] nums, int n) {
        int sum = 0;
        int i = 0 ;
        int patch = 0;
        while(i < nums.length && sum < n){
            if(sum + 1 >= nums[i]){
                sum += nums[i];
                i++;
            }else{
                patch++;
                sum += sum + 1;
            }
        }
        return patch;
    }
}
