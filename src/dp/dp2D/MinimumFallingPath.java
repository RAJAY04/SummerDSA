package dp.dp2D;

import java.util.Arrays;

public class MinimumFallingPath {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
        System.out.println(tabulation(matrix));
        System.out.println(spaceOptimisation(matrix));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int row =  matrix.length , col = matrix[0].length;
        int[][] dp= new int[row][col];
        for(int[] arr : dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
            //matrix may contain negative values, so dont fill it with - 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < row ; i++){
            min = Math.min(min,memo(matrix,0,i,dp));
        }
        return min;
    }

    public static int memo(int[][] matrix, int row , int col, int[][] dp){
        if(row == matrix.length - 1)return matrix[row][col];

        if(dp[row][col] != Integer.MAX_VALUE)return dp[row][col];

        int down = Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = Integer.MAX_VALUE ;
        int min = Integer.MAX_VALUE;

        down = memo(matrix,row + 1, col , dp);
        if(col > 0)
            left = memo(matrix,row + 1, col - 1, dp);
        if(col < matrix.length - 1)
            right = memo(matrix,row + 1, col + 1, dp);
        min = Math.min(Math.min(left,right),down) + matrix[row][col];

        return dp[row][col] = min;
    }

    public static int tabulation(int[][] matrix){
        int row = matrix.length;
        int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        int[][] dp = new int[row][row];
        for(int i = row - 1 ; i >= 0 ; i--){
            for(int j = row - 1; j >= 0 ; j--){
                if(i == row - 1){
                    dp[i][j] = matrix[i][j];
                }else{
                    up = dp[i + 1][j] + matrix[i][j];
                    left = (j > 0) ? dp[i + 1][j - 1] + matrix[i][j] : Integer.MAX_VALUE;//make sure to do INTMAX
                    right = (j < row - 1) ? dp[i + 1][j + 1] + matrix[i][j] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(up,Math.min(left,right));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < row ; i++){
            ans = Math.min(dp[0][i],ans);
        }
        return ans;
    }

    public static int spaceOptimisation(int[][] matrix){
        int row = matrix.length;
        int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        int[] cur = new int[row];
        int[] prev = new int[row];
        for(int i = row - 1 ; i >= 0 ; i--){
            for(int j = row - 1; j >= 0 ; j--){
                if(i == row - 1){
                    prev[j] = matrix[i][j];
                }else{
                    up = prev[j] + matrix[i][j];
                    left = (j > 0) ? prev[j - 1] + matrix[i][j] : Integer.MAX_VALUE;//make sure to do INTMAX
                    right = (j < row - 1) ? prev[j + 1] + matrix[i][j] : Integer.MAX_VALUE;
                    cur[j] = Math.min(up,Math.min(left,right));
                }
            }if(i < row -1 )prev = cur.clone();
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < row ; i++){
            ans = Math.min(prev[i],ans);
        }
        return ans;
    }
}
