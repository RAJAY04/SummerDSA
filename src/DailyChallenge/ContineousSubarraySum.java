package DailyChallenge;

import java.util.HashMap;

public class ContineousSubarraySum {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum % k == 0 && i > 0)
                return true;

            if (map.containsKey(sum % k) && i - map.get(sum % k) >= 2)
                return true;

            if (!map.containsKey(sum % k))
                map.put(sum % k, i);
        }

        return false;
    }
}
