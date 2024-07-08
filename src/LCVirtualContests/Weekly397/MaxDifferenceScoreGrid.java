package LCVirtualContests.Weekly397;

import java.util.Arrays;
import java.util.List;

public class MaxDifferenceScoreGrid {
    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        System.out.println(maxScore(grid));
    }

    public static int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dp = new int[n][m];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        int max = Integer.MIN_VALUE;
        int atLeastOneMove = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, memo(grid, i, j, dp));
                if (i + 1 < n) atLeastOneMove = Math.max(atLeastOneMove, grid.get(i + 1).get(j) - grid.get(i).get(j));
                if (j + 1 < m) atLeastOneMove = Math.max(atLeastOneMove, grid.get(i).get(j + 1) - grid.get(i).get(j));
                //above two lines are to handle if our recursive call do any cal as best is can do is 0 without making any move
                //its just enough handling down and right: dry run second eg of leetcode and see, neightbouring values itslef
                //will be minimum in 0 move situation
            }
        }
        if (max == 0) return atLeastOneMove;
        return max;
    }

    public static int memo(List<List<Integer>> grid, int i, int j, int[][] dp) {
        if (i >= grid.size() || j >= grid.getFirst().size()) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int pick1 = Integer.MIN_VALUE, pick2 = Integer.MIN_VALUE;

        if (i + 1 < grid.size()) {
            pick1 = grid.get(i + 1).get(j) - grid.get(i).get(j) + memo(grid, i + 1, j, dp);
        }
        if (j + 1 < grid.getFirst().size()) {
            pick2 = grid.get(i).get(j + 1) - grid.get(i).get(j) + memo(grid, i, j + 1, dp);

        }
        return dp[i][j] = Math.max(0, Math.max(pick1, pick2));//0 is necessary, which mean we are not making any move if -ve values
    }

  //tabulation is complex

}