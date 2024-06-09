package DailyChallenge;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {-1,2,9};
        int k = 2;
        System.out.println(subarraysDivByK(arr,k));
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
