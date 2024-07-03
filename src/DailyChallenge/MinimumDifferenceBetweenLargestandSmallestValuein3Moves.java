package DailyChallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumDifferenceBetweenLargestandSmallestValuein3Moves {
    public static void main(String[] args) {
        int[] nums = {1,5,0,10,14};
        System.out.println(minDifference(nums));
        System.out.println(minDifference1(nums));
    }


    //here the time complexity is O(nlogn) and space complexity is O(n + logn) because we are modifying array in place
    public static int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4)return 0;
        Arrays.sort(nums);
        int option1 = Math.abs(nums[3] - nums[n - 1]);
        int option2 = Math.abs(nums[n - 4] - nums[0]);
        int option3 = Math.abs(nums[n - 2] - nums[2]);
        int option4 = Math.abs(nums[n - 3] - nums[1]);
        return Math.min(Math.min(option1,option2),Math.min(option4,option3));
    }

    public static int minDifference1(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // default min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // max heap

        // Populate the heaps
        for (int num : nums) {
            minHeap.add(num);
            maxHeap.add(num);
            if (minHeap.size() > 4) minHeap.poll();
            if (maxHeap.size() > 4) maxHeap.poll();
        }

        int[] arr = new int[8];
        int l = 3, r = 4;

        while (!maxHeap.isEmpty()) {
            arr[l--] = maxHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            arr[r++] = minHeap.poll();
        }

        int m = 8;
        int option1 = Math.abs(arr[m - 4] - arr[0]);
        int option2 = Math.abs(arr[m - 3] - arr[1]);
        int option3 = Math.abs(arr[m - 2] - arr[2]);
        int option4 = Math.abs(arr[m - 1] - arr[3]);

        // Return the minimum difference
        return Math.min(Math.min(option1, option2), Math.min(option3, option4));

    }
}
