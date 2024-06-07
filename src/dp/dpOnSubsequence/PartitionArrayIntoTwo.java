package dp.dpOnSubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionArrayIntoTwo {
    public static void main(String[] args) {
        int[] nums = {3,9,7,3};
        System.out.println(minimumDifference(nums));
        //couldnt do this quesiton complex shit
        //we could not apply tabulation because the numbers may be negative too and hence -ve index tabulation impossible
        }

    public static int minimumDifference(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int N = n / 2;
        List<List<Integer>> left = new ArrayList<>(N + 1);
        List<List<Integer>> right = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; ++i) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        // All possible sums in left and right part (Generating and storing using BIT-Masking)
        for (int mask = 0; mask < (1 << N); ++mask) {
            int idx = 0, l_sum = 0, r_sum = 0;
            for (int i = 0; i < N; ++i) {
                if ((mask & (1 << i)) != 0) { // To check if the bit is set or not
                    idx++;
                    l_sum += nums[i];
                    r_sum += nums[i + N];
                }
            }
            left.get(idx).add(l_sum);
            right.get(idx).add(r_sum);
        }

        for (int idx = 0; idx <= N; ++idx) {
            Collections.sort(right.get(idx)); // Sort right to perform binary search
        }

        int res = Math.min(Math.abs(sum - 2 * left.get(N).get(0)), Math.abs(sum - 2 * right.get(N).get(0)));

        // Iterating over left part
        for (int idx = 1; idx < N; ++idx) { // Iterate from 1 to N-1
            for (int a : left.get(idx)) {
                int b = (sum - 2 * a) / 2;
                int rightidx = N - idx;
                List<Integer> v = right.get(rightidx);
                int pos = Collections.binarySearch(v, b);

                if (pos < 0) {
                    pos = -pos - 1;
                }

                if (pos < v.size()) {
                    res = Math.min(res, Math.abs(sum - 2 * (a + v.get(pos))));
                }

                if (pos > 0) {
                    res = Math.min(res, Math.abs(sum - 2 * (a + v.get(pos - 1))));
                }
            }
        }
        return res;
    }
}

