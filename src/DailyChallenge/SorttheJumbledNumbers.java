package DailyChallenge;

import java.util.*;

public class SorttheJumbledNumbers {
    public static void main(String[] args) {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};
        int[] res = sortJumbled(mapping,nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> map = new ArrayList<>();
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int mappedValue = mapValue(num, mapping);
            map.add(new int[]{num, mappedValue, i});
        }

        // Sort based on mapped values, with index as tie-breaker
        map.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });

        // Extract the sorted numbers
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(i)[0];
        }

        return res;
    }

    private static int mapValue(int num, int[] mapping) {
        if (num == 0) return mapping[0];
        int mappedValue = 0;
        int place = 1;
        while (num > 0) {
            int digit = num % 10;
            mappedValue = mapping[digit] * place + mappedValue;
            num /= 10;
            place *= 10;
        }
        return mappedValue;
    }

    //private int mapValue(int num, int[] mapping) {//this was my mapping logic
    //        if (num == 0) {
    //            return mapping[0];
    //        }
    //
    //        int res = 0;
    //        int len = (int) Math.log10(num) + 1; // Length of the number
    //        int div = (int) Math.pow(10, len - 1); // Divisor to extract the most significant digit
    //
    //        while (num > 0) {
    //            int rem = num / div; // Extract the most significant digit
    //            res = res * 10 + mapping[rem]; // Map the digit and add it to the result
    //            num %= div; // Remove the most significant digit
    //            div /= 10; // Update the divisor to the next digit
    //        }
    //
    //        return res;
    //    }
}
