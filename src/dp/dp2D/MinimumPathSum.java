package dp.dp2D;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        System.out.println(tabulation(grid));
        System.out.println(spaceOptimisation(grid));
    }

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memo(grid, row - 1, col - 1, dp);
    }

    public static int memo(int[][] grid, int row, int col, int[][] dp) {
        if (row == 0 && col == 0) return grid[0][0];

        if (dp[row][col] != -1) return dp[row][col];

        int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;

        if (col > 0) {
            up = memo(grid, row, col - 1, dp);
        }

        if (row > 0) {
            left = memo(grid, row - 1, col, dp);
        }

        return dp[row][col] = Math.min(left, up) + grid[row][col];

    }

    public static int tabulation(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                } else {
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                }
                dp[i][j] = grid[i][j] + Math.min(up,left);
            }
        }
        return dp[row - 1][col - 1];
    }
    public static int spaceOptimisation(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                    continue;
                } else {
                    if (i > 0) up = dp[j];
                    if (j > 0) left = dp[j - 1];
                }
                dp[j] = grid[i][j] + Math.min(up,left);
            }
        }
        return dp[col - 1];
    }
}
