package dp.dpOnLIS;

import javax.management.StandardEmitterMBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence(nums.length,nums));
    }

    public static ArrayList<Integer> longestIncreasingSubsequence(int n, int[] arr) {
        // Step 1: Initialize dp array to store lengths of LIS ending at each index
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize each element's LIS length as 1 since each element itself is a subsequence

        // Index array to track the previous index in the LIS for reconstruction
        int[] indexes = new int[n];
        Arrays.fill(indexes, -1); // Initialize indexes array with -1 (no previous index initially)

        // Step 2: Compute LIS lengths and track previous indices
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                // Check if the current element can be added to the LIS ending at 'prev'
                if (arr[prev] < arr[i]) {
                    // Update dp[i] if adding arr[i] to LIS ending at 'prev' gives a longer subsequence
                    if (dp[prev] + 1 > dp[i]) {
                        dp[i] = dp[prev] + 1;
                        indexes[i] = prev; // Update index to track the previous element in the LIS
                    }
                }
            }
        }

        // Step 3: Find the maximum length of LIS and its ending index
        int maxLength = 0;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Step 4: Reconstruct the LIS from the indexes array
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]); // Add the last element of the LIS

        // Traverse backwards using indexes array to add elements in correct order
        while (indexes[lastIndex] != -1) {//check notes for dry run, this is really a unique thing
            lastIndex = indexes[lastIndex];
            lis.add(arr[lastIndex]);
        }

        // Step 5: Return the LIS in reverse order (since we built it backwards)
        Collections.reverse(lis);
        return lis;
    }
}
