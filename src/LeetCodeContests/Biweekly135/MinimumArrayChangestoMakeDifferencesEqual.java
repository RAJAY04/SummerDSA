package LeetCodeContests.Biweekly135;

import java.util.HashMap;
import java.util.Map;

public class MinimumArrayChangestoMakeDifferencesEqual {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,3,6,5,4};
        int k = 6;
        System.out.println(minChanges(nums,k));
    }

    public static int minChanges(int[] nums, int k) {
        int n = nums.length;
        int m = n / 2;
        int[] diff = new int[m];
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++){
            diff[i] = Math.abs(nums[i] - nums[n - i - 1]);
            minDiff = Math.min(minDiff,diff[i]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < m ; i++){
            map.put(diff[i],map.getOrDefault(diff[i], 0)+ 1);
        }

        int maxCount = Integer.MIN_VALUE;
        int maxCountDiff = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxCountDiff = entry.getKey();
            }
        }

        int res = 0;
        for(int i = 0 ; i < m ; i++){
            int curDiff = Math.abs(nums[i] - nums[n - i - 1]);
            if(maxCountDiff != curDiff){
                if(Math.max(nums[i],nums[n - i - 1]) >= maxCountDiff){
                    res++;
                }else res += 2;
            }
        }
        int res1 = 0;
        for(int i = 0 ; i < m ; i++){
            int curDiff = Math.abs(nums[i] - nums[n - i - 1]);
            if(minDiff != curDiff){
                if(Math.max(nums[i],nums[n - i - 1]) >= minDiff){
                    res++;
                }else res += 2;
            }
        }
        return res;
    }
}
