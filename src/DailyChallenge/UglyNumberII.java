package DailyChallenge;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        Set<Long> set = new HashSet<>();
        long[] factors = {2, 3, 5};

        for(int i = 0; i < n; i++) {
            long num = queue.poll();
            if (i == n - 1) return (int) num;

            for (long f : factors) {
                long nextNum = num * f;
                if (!set.contains(nextNum)) {
                    queue.add(nextNum);
                    set.add(nextNum);
                }
            }
        }
        return -1;
    }
}
