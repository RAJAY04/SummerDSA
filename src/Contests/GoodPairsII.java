package Contests;

import java.util.HashMap;
import java.util.Map;

public class GoodPairsII {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4};
        int[] nums2 = {1,3,4};
        int k = 1;
        System.out.println(numberOfPairs(nums1, nums2, k));
    }
    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long count = 0;
        Map<Long, Long> map = new HashMap<>();
        for (long num : nums2) {
            long key = num * k;
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        for (long num : nums1) {
            if(num % k != 0)continue;
            for(int f = 1 ; f * f <= num ; f++){
                if(num % f != 0)continue;
                long f1 = f , f2 = num /f;
                count += map.getOrDefault(f1,0L);
                if(f1 != f2)count += map.getOrDefault(f2,0L);
            }
        }

        return count;
    }
}
