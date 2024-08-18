package DailyChallenge;

import java.util.List;

public class maxDiffInTheArrays {
    public static void main(String[] args) {
        List<List<Integer>> arrays = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(1, 2, 3));
        System.out.println(maxDistance(arrays));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int len = arrays.get(i).size();
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(len - 1);
            int diff1 = Math.abs(min - curMax);
            int diff2 = Math.abs(max - curMin);
            maxDiff = Math.max(Math.max(diff1, diff2), maxDiff);
            min = Math.min(curMin, min);
            max = Math.max(max, curMax);
        }
        return maxDiff;
    }
}
