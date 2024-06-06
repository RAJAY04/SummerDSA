package dp.dp2D;

import java.util.Arrays;

public class ChocolatePickups {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };
        System.out.println(solve(4, 4, grid));
        System.out.println(tabulation(4,4,grid));
        System.out.println(spaceOptimisation(4,4,grid));
    }

    public static int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];
        for (int[][] arr1 : dp) {
            for (int[] arr : arr1) {
                Arrays.fill(arr, -1);
            }
        }
        return memo(grid, 0, 0, m - 1, dp);
    }

    public static int memo(int[][] matrix, int row, int col1, int col2, int[][][] dp) {
        // Check if out of bounds (Changed)
        if (col1 < 0 || col2 < 0 || col1 >= matrix[0].length || col2 >= matrix[0].length) {
            return -100000;
        }

        if (row == matrix.length - 1) {
            return (col1 == col2) ? matrix[row][col1] : matrix[row][col1] + matrix[row][col2];
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int max = -100000;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int nextCol1 = col1 + d1;
                int nextCol2 = col2 + d2;
                int current = (col1 == col2) ? matrix[row][col1] : matrix[row][col1] + matrix[row][col2];
                max = Math.max(max, current + memo(matrix, row + 1, nextCol1, nextCol2, dp));
            }
        }

        return dp[row][col1][col2] = max;
    }

    static int tabulation(int n, int m, int[][] grid) {
        // Create a 3D array to store computed results
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the dp array
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        // The final result is stored at the top row (first row) of the dp array
        return dp[0][0][m - 1];
    }

    static int spaceOptimisation(int n, int m, int[][] grid) {
        // Create two 2D arrays to store computed results: front and cur
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        // Initialize the front array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the cur array
                    cur[j1][j2] = maxi;
                }
            }

            // Update the front array with the values from the cur array for the next row
            for (int a = 0; a < m; a++) {
                front[a] = cur[a].clone();
            }
        }

        // The final result is stored at the top left corner of the front array
        return front[0][m - 1];
    }

}
