package DailyChallenge;

import java.util.Arrays;

public class MinIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,7};
        System.out.println(minIncrementForUnique1(nums));
        System.out.println(minIncrementForUnique(nums));
    }
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0 , j = 1;
        int ans = 0;
        while(j < n){
            if(nums[i] == nums[j]){
                nums[j]++;
                ans++;
            }else if(nums[i] > nums[j]){
                ans += nums[i] - nums[j] + 1;
                nums[j] += nums[i] - nums[j] + 1;
            }
            i++;
            j++;

        }
        return ans;
    }
    public static int minIncrementForUnique1(int[] nums) {
        int[] freq = new int[100001];
        for(int num: nums){
            freq[num]++;
        }
        int ans = 0;
        for(int i = 0 ; i < 100000; i++){
            if(freq[i] == 0){
                continue;
            }else if(freq[i] > 1){
                int extra = freq[i] - 1;
                freq[i] = 1;
                ans += extra;
                freq[i + 1] += extra;
            }
        }
        int extra = 0;
        if(freq[100000] > 1)
            extra = freq[100000] - 1;
        ans += extra * (extra + 1) / 2;//say freq[100000] => distribute like 10,9,8,7 soo sum of extras
        return ans;
    }
}
