package dp.random;

import java.util.Arrays;

public class MinimalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
        System.out.println(tabulation(matrix));
        System.out.println(spaceOptimisation(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        int max = 0;
        for(int i = 0  ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == '1')//we use dp array to cache so not a lot of time complexity
                    max = Math.max(max,memo(matrix,i,j,dp));
            }
        }//there is no way we can escape this two for loops
        //consideer a eg
        // 0    0    0
        // 0    0    0
        // 1    1    1
        // 1    1    1
//hwere in 0,0 call we just get 0 from all sides, as our function just return 0 when we find a  0
        return max * max;
    }
    public static int memo(char[][] matrix,int i, int j , int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0')return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int right = memo(matrix, i, j + 1, dp);
        int down = memo(matrix, i + 1, j, dp);
        int diagonal = memo(matrix, i + 1, j + 1, dp);
        return dp[i][j] = (matrix[i][j] - '0') + Math.min(right, Math.min(down, diagonal));

    }


    public static int tabulation(char[][] matrix){
        int n = matrix.length , m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(dp[i][j - 1],Math.min(dp[i - 1][j] , dp[i - 1][j - 1])) + 1;
                    ans = Math.max(dp[i][j],ans);
                }
            }
        }//or what we could do is , iterate through dp array and find max;
        return ans * ans;
    }
    public static int spaceOptimisation(char[][] matrix){
        int n = matrix.length , m = matrix[0].length;
        int[] prevDp = new int[m + 1];
        int[] curDp = new int[m + 1];

        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            curDp = new int[m + 1];
            for(int j = 1 ; j <= m ; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    curDp[j] = Math.min(curDp[j - 1],Math.min(prevDp[j] , prevDp[j - 1])) + 1;
                    ans = Math.max(curDp[j],ans);
                }
            }
            prevDp = curDp;
        }
        return ans * ans;
    }
}
