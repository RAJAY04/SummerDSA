package DailyChallenge;

import java.util.PriorityQueue;

public class KthLargestElementinaStream {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
    static class KthLargest {
        PriorityQueue<Integer> pq;
        int k=0;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for(int i: nums) {
                this.add(i);
            }
        }

        public int add(int val) {
            pq.add(val);
            if(pq.size() > k)pq.poll();
            return pq.peek();
        }
    }
}
