package DailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersctionOfTwoArraysII {
    public static void main(String[] args) {

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = new int[1001];
        int[] freq2 = new int[1001];

        // Populate frequency arrays
        for (int num : nums1) {
            freq1[num]++;
        }
        for (int num : nums2) {
            freq2[num]++;
        }

        // Find intersection elements
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            int count = Math.min(freq1[i], freq2[i]); // Get the minimum count for intersection
            while (count > 0) {
                list.add(i); // Add i to the list count times
                count--;
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
