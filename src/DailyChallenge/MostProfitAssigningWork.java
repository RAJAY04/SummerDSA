package DailyChallenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty,profit,worker));
        System.out.println(maxProfitAssignment(difficulty,profit,worker));
    }
    public static int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int[][] combined = new int[n][2];
        for (int i = 0; i < n; i++) {
            combined[i][0] = difficulty[i];
            combined[i][1] = profit[i];
        }

        Arrays.sort(combined, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        // Update the profit array to contain the maximum profit at each difficulty level
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, combined[i][1]);
            combined[i][1] = max;
        }

        Arrays.sort(worker);

        int ans = 0;
        int j = 0;
        int m = worker.length;
        for (int i = 0; i < m; i++) {
            int cap = worker[i];
            while (j < n && cap >= combined[j][0]) {
                j++;
            }
            if (j > 0) {
                ans += combined[j - 1][1];
            }
        }
        return ans;
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        int maxEle = 0;
        for(int i = 0 ; i < n ; i++){
            maxEle = Math.max(difficulty[i],maxEle);
        }

        int[] dp = new int[maxEle + 1];
        for(int i = 0 ; i < n ; i++){
            dp[difficulty[i]] = Math.max(dp[difficulty[i]],profit[i]);
        }
        for(int i = 1 ; i <= maxEle ; i++){
            dp[i] = Math.max(dp[i],dp[i - 1]);
        }

        int profSum = 0;
        for(int i = 0  ; i < m ; i++){
            if(worker[i] <= maxEle){
                profSum += dp[worker[i]];
            }else{
                profSum += dp[maxEle];//edge case where if we have worker[i]  > maxEle then ans is by default maxProfit
            }
        }
        return profSum;
    }
}
