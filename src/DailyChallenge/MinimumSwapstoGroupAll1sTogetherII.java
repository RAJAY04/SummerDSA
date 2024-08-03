package DailyChallenge;

public class MinimumSwapstoGroupAll1sTogetherII {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        int total = 0;
        for(int num : nums)if(num == 1)total++;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int i = 0 , j = total - 1;
        int zeroCount = 0;
        for(int temp = i ; temp <= j; temp++)if(nums[temp] == 0)zeroCount++;
        int ctr = 2 * n;
        while(ctr-- > 0){
            min = Math.min(zeroCount,min);
            j = (j + 1) % n;
            zeroCount += (nums[j] == 0) ? 1 : 0;
            zeroCount -= (nums[i] == 0) ? 1 : 0;
            i = (i + 1) % n;
        }
        return min;
    }
}
