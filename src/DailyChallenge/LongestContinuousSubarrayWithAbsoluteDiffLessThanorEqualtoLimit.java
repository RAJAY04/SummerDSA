package DailyChallenge;

import java.util.*;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public static void main(String[] args) {
          int[] arr = {8,2,4,7};
        System.out.println(longestSubarray(arr,4));
    }
    public static int longestSubarray(int[] nums, int limit) {
        int maxLen = 0 , i = 0 , j = 0;
        int n = nums.length;
        TreeMap<Integer,Integer> multiSet = new TreeMap<>();
        while(j < n){
            multiSet.put(nums[j],multiSet.getOrDefault(nums[j],0)+1);
            while(i <= j && Math.abs(multiSet.lastKey() - multiSet.firstKey()) > limit){
                multiSet.put(nums[i],multiSet.getOrDefault(nums[i],0)-1);
                if(multiSet.get(nums[i])== 0){
                    multiSet.remove(nums[i]);
                }
                i++;
            }
            maxLen = Math.max(maxLen,j - i + 1);
            j++;
        }
        return maxLen;
    }


    public static int longestSubarray2(int[] nums, int limit) {
        int n = nums.length, i = 0, j = 0, maxLen = 0;

        // Max-Heap for the maximum elements
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // Min-Heap for the minimum elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        while (j < n) {
            maxHeap.offer(new int[]{nums[j], j});
            minHeap.offer(new int[]{nums[j], j});

            int diff = maxHeap.peek()[0] - minHeap.peek()[0];

            while (i < j && diff > limit) {
                i = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < i) maxHeap.poll();
                while (!minHeap.isEmpty() && minHeap.peek()[1] < i) minHeap.poll();

                diff = maxHeap.peek()[0] - minHeap.peek()[0];
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
    //this is the most optimal given below both bit O of N time and space

    public static int longestSubarray1(int[] nums, int limit) {
        int n = nums.length, i = 0, j = 0, maxLen = 0;
        Deque<int[]> maxDeq = new LinkedList<>();
        Deque<int[]> minDeq = new LinkedList<>();

        while (j < n) {
            while (!maxDeq.isEmpty() && maxDeq.peekLast()[0] < nums[j]) maxDeq.pollLast();
            maxDeq.addLast(new int[]{nums[j], j});
            while (!minDeq.isEmpty() && minDeq.peekLast()[0] > nums[j]) minDeq.pollLast();
            minDeq.addLast(new int[]{nums[j], j});

            int diff = maxDeq.peekFirst()[0] - minDeq.peekFirst()[0];
            while (i < j && diff > limit) {
                i = Math.min(maxDeq.peekFirst()[1], minDeq.peekFirst()[1]) + 1;
                while (!maxDeq.isEmpty() && maxDeq.peekFirst()[1] < i) maxDeq.pollFirst();
                while (!minDeq.isEmpty() && minDeq.peekFirst()[1] < i) minDeq.pollFirst();
                diff = maxDeq.peekFirst()[0] - minDeq.peekFirst()[0];
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
