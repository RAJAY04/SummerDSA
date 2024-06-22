package Extras;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        // Using the first method
        int result1 = numSubarraysWithSum(nums, goal);
        System.out.println("Number of subarrays with sum " + goal + " using first method: " + result1);

        // Using the second method
        int result2 = numSubarraysWithSum1(nums, goal);
        System.out.println("Number of subarrays with sum " + goal + " using second method: " + result2);
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int ans = 0;
        for(int i = 0 ; i < nums.length ;i++){
            preSum += nums[i];
            if(map.containsKey(preSum - goal)){
                ans += map.get(preSum - goal);
            }
            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }//prev sum can be used for any range sum problems, irrespective of the value of nums

    public static int numSubarraysWithSum1(int[] nums, int goal) {
        return function(nums,goal) - function(nums,goal - 1);
        //no of subarray with sum == goal = no of subarray with sum <= goal - no of subarray with sum < goal
        //we cant use simple sliding window because the array contains 0.
    }
    public static int function(int[] nums,int goal){
        int i = 0 , j = 0 ;
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        while(j < n){
            sum += nums[j];
            while(i <= j && sum > goal){
                sum -= nums[i];
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}
