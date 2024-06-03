package dp.dp2D;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
        System.out.println(uniquePaths1(3,7));
        System.out.println(tabulation(3,7));
    }
    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        return memo(m - 1 , n - 1 , dp);
    }

    public static int memo(int row, int col , int[][] dp){
        if(row == 0 && col == 0)return 1;

        if(dp[row][col] != -1)return dp[row][col];

        int ans = 0;
        if(row > 0)
            ans += memo(row - 1 , col, dp);
        if(col > 0)
            ans += memo( row , col -1 ,dp);

        return dp[row][col] = ans;
    }

    public static int tabulation(int row , int col){
        int[][] dp = new int[row][col];
        for(int i = 0 ; i < row ; i++){
           dp[i][0] = 1;
        }
        for(int i = 0 ; i < col ; i++){
            dp[0][i] = 1;
        }
        for(int i = 1 ; i < row ; i++){
            for(int j = 1; j < col ; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static int uniquePaths(int row, int col) {//space optimisation
        int cur = 0;
        int[] upRow = new int[col];
        Arrays.fill(upRow,1);
        for(int i = 1 ; i < row ; i++){
            for(int j = 1; j < col ; j++){
                cur = upRow[j] + upRow[j - 1];
                upRow[j] = cur;
            }
        }
        return upRow[col - 1];
    }



}
