package DailyChallenge;

import java.util.Arrays;
import java.util.OptionalLong;

public class MaximumNumberofPointswithCost {
    public static void main(String[] args) {
        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
        System.out.println(maxPoints(points));
    }
    public static long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long[][] dp = new long[n][m];
        for(long[] arr : dp) Arrays.fill(arr, - 1);
        long res = 0;
        for(int i = 0 ; i < points[0].length; i++){
            res = Math.max(res,memo(points,0,i,dp));
        }
        return res;
    }

    public static long memo(int[][] points,int row,int col,long[][] dp){
        if(row == points.length - 1)return points[row][col];

        if(dp[row][col] != -1)return dp[row][col];

        long res = Integer.MIN_VALUE;
        long max = 0;
        for(int i = 0; i < points[0].length; i++){
            max = points[row][col] - Math.abs(col - i) + memo(points,row + 1,i,dp);
            res = Math.max(res,max);
        }
        return dp[row][col] = res;
    }//gives TLE

    public static long tabulation(int[][] points){
        int n = points.length;
        int m = points[0].length;
        long[] row = new long[m];
        for(int i = 0 ; i < m; i++){
            row[i] = points[0][i];
        }

        for(int r = 1; r < n; r++){
            long[] nextRow = new long[m];
            for(int i = 0 ; i < m; i++)nextRow[i] = points[r][i];
            long[] left = new long[m], right = new long[m];

            left[0] = row[0];
            for(int c = 1 ; c < m; c++){
                left[c] = Math.max(row[c],left[c - 1] - 1);
            }

            right[m - 1] = row[m - 1];
            for(int c = m - 2; c >= 0 ; c--){
                right[c] = Math.max(row[c],right[c + 1] - 1);
            }

            for(int c = 0 ; c < m ; c++){
                nextRow[c] += Math.max(left[c],right[c]);
            }

            row = nextRow.clone();
        }
        long max = Integer.MIN_VALUE;
        for(long num : row)max = Math.max(num,max);
        return max;
    }
}
