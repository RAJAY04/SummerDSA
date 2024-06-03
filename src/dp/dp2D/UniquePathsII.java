package dp.dp2D;

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0},{1,0,0,0},{0,1,0,0},{0,0,1,0}};
        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println(tabulation(grid));
        System.out.println(spaceOptimisation(grid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length , n = obstacleGrid[0].length;
        if(m == 1 && n == 1 && obstacleGrid[0][0] == 0)return 1;
        if(m == 1 && n == 1 && obstacleGrid[0][0] == 1)return 0;
        if(obstacleGrid[0][0] == 1)return 0;
        if(obstacleGrid[m - 1][n - 1] == 1)return 0;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        return memo(obstacleGrid,m - 1 , n - 1 , dp);
    }
    public static int memo(int[][] grid,int row, int col , int[][] dp){
        if(row == 0 && col == 0)return 1;
        if(grid[row][col] == 1)return 0;
        if(dp[row][col] != -1)return dp[row][col];

        int ans = 0;
        if(row > 0)
            ans += memo(grid,row - 1 , col, dp);
        if(col > 0)
            ans += memo(grid,row , col -1 ,dp);

        return dp[row][col] = ans;
    }

    public static int tabulation(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        if(row == 1 && col == 1 && grid[0][0] == 0)return 1;
        if(row == 1 && col == 1 && grid[0][0] == 1)return 0;
        if(grid[0][0] == 1)return 0;
        if(grid[row - 1][col - 1] == 1)return 0;
        int[][] dp = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            if(grid[i][0] == 1){
                for(int j = i; j < row ; j++){
                    dp[j][0] = 0;
                }
                break;
            }else{
                dp[i][0] = 1;
            }
        }
        for(int i = 0 ; i < col ; i++){
            if(grid[0][i] == 1){
                for(int j = i; j < col ; j++){
                    dp[0][j] = 0;
                }
                break;
            }else{
                dp[0][i] = 1;
            }
        }
        int up , left;
        for(int i = 1 ; i < row ; i++){
            for(int j = 1; j < col ; j++){
                if(grid[i][j] == 1)continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static int spaceOptimisation(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        if(row == 1 && col == 1 && grid[0][0] == 0)return 1;
        if(row == 1 && col == 1 && grid[0][0] == 1)return 0;
        if(grid[0][0] == 1)return 0;
        if(grid[row - 1][col - 1] == 1)return 0;
        int[] dp = new int[col];
        for(int i = 0 ; i < col ; i++){
            if(grid[0][i] ==  1){
                for(int j = i ; j < col ; j++){
                    dp[j] = 0;
                }break;
            }else dp[i] = 1;
        }
        for(int i = 1 ; i < row ; i++){
            for(int j = 1; j < col ; j++){
                if(grid[i][j - 1] == 1)dp[j - 1] = 0;
                if(grid[i][j] == 1){
                    dp[j] = 0;
                }
                else dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[col - 1];

    }
}
