package DailyChallenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        int result = findMaximizedCapital(k, w, profits, capital);
        System.out.println("The maximized capital is: " + result);
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Comparator<int[]> capitalComparator = (a,b) -> Integer.compare(a[0],b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(capitalComparator);

        for (int i = 0; i < profits.length; i++) {
            minHeap.add(new int[]{capital[i], profits[i]});
        }


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            // Move all feasible projects from the min-heap to the max-heap
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                int[] project = minHeap.poll();
                maxHeap.add(project[1]);
            }

            // If there are no feasible projects left, break out of the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the most profitable project from the max-heap
            w += maxHeap.poll();
        }

        return w;
//The total complexity for the k iterations of the outer loop is
//O(k⋅nlogn).
    }
}
