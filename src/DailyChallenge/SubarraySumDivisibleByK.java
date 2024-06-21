package DailyChallenge;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {-1,2,9};
        int k = 2;
        System.out.println(subarraysDivByK(arr,k));
    }
    public int subarraysDivByK1(int[] nums, int k) {
        Map<Integer,Integer>  map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int preSum = 0;
        int rem = 0;
        for(int i = 0 ; i < nums.length ;i++){
            preSum += nums[i];
            rem = ((preSum % k )+ k) % k;//this line is usually used to ensure remainder dosent go negative
            //note that we can use % k anytimes safely, as it dosent alter our result
            //note that we are not modifying presum, we just modify remainder
            //Explanation of rem Calculation
            //preSum % k gives the remainder of preSum divided by k.
            //If preSum is negative, preSum % k will be negative, and we need to convert it to a positive equivalent in the range [0, k-1].
            //((preSum % k) + k) % k ensures that the remainder is non-negative:
            //(preSum % k) + k adds k to ensure non-negativity.
            //The outer % k ensures the value is within the range [0, k-1].
            //Why it Doesn't Affect the Answer
            //The equivalence of remainders in modular arithmetic means that converting a negative remainder to its positive equivalent does not affect the subarray sums being divisible by k.
            if(map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem,map.get(rem)+1);
            }else map.put(rem,1);
        }
        return ans;
    }
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0, res = 0;
        for (int num : nums) {
            preSum += num;
            int rem = preSum % k;
            if (rem < 0) {
                rem += k;//handling -ve remainders
            }
            if (map.containsKey(rem)) {
                res += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}
