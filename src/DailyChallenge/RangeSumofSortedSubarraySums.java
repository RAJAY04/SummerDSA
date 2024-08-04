package DailyChallenge;

import java.util.*;

public class RangeSumofSortedSubarraySums {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 5;
        System.out.println(rangeSum(nums, n, left, right)); // Should print 13
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        List<Integer> subarraySums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }

        Collections.sort(subarraySums);

        long result = 0;
        for (int k = left - 1; k < right; k++) {
            result = (result + subarraySums.get(k)) % mod;
        }

        return (int) result;
    }

    static class Pair{
        int sum;
        int index;
        Pair(int sum,int index){
            this.sum = sum;
            this.index = index;
        }
    }
    public static int rangeSum1(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        for(int i = 0 ; i < n; i++){
            pq.add(new Pair(nums[i],i));
        }
        int mod = (int)(1e9) + 7;
        int res = 0;
        for(int i = 0; i <= right - 1; i++){
            int sum = pq.peek().sum;
            int index = pq.poll().index;

            if(i >= left - 1){
                res = (res + sum) % mod;
            }
            if(index + 1 < n){
                Pair p = new Pair(sum + nums[index + 1],index + 1);
                pq.add(p);
            }
        }
        return res;
    }
}
