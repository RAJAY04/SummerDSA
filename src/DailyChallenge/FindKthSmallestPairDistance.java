package DailyChallenge;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        int[] nums = {1,3,1};
        int k = 1;
        System.out.println(smallestDistancePair(nums, k));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        max = Math.abs(nums[0] - nums[n - 1]);
        for(int i = 0 ; i < n - 1; i++){
            min = Math.min(Math.abs(nums[i] - nums[i + 1]),min);
        }

        int s = min, e = max;
        while(s < e){
            int mid = s + (e - s)/2;
            if(!helper(nums,mid,k)){
                s = mid + 1;
            }else{
                e = mid;
            }
        }
        return s;
    }
    public static boolean helper(int[] nums,int diff, int k){
        int count = 0;
        int n = nums.length;
        for (int i = 0, j = 0; j < n; j++) {
            while (i < n && nums[j] - nums[i] > diff) {
                i++;
            }
            count += j - i;
        }
        return count <= k;
    }
}
