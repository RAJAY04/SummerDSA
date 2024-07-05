package dp.dpOnSquares;

public class CountSquareMatWithAllOnes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(matrix));
        System.out.println(countSquares1(matrix));
    }


    //this is strivers taught code
    public static int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = matrix[i][0];
            count+= dp[i][0];//or else at the end we can iterate over the dp array and count the number of 1's
        }
        for(int i = 0 ; i < m ; i++){
            dp[0][i] = matrix[0][i];
            count+= dp[0][i];
        }
        if(matrix[0][0] == 1)count--;//reduce redundant count
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1],dp[i - 1][j -1]));
                    count += dp[i][j];
                    //dp[i][j] states the length of the square matrix with all 1's ending at i,j
                }
            }
        }
        return count;

    }
    //this code is as of square matrix qn of aryan
    public static int countSquares1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int count = 0;
        for(int i = 1 ; i <= n ;i++){
            for(int j = 1 ; j <= m ; j++){
                if(matrix[i - 1][j - 1] == 1){
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1],dp[i - 1][j -1]));
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}
