package LCVirtualContests.Weekly394;

import java.util.Arrays;

public class MinimumNumberofOperationstoSatisfyConditions {
    public static void main(String[] args) {
        int[][] grid = {{4,5,0,1},{1,9,0,8},{2,2,5,3},{2,0,9,3}};
        System.out.println(minimumOperations(grid));
        System.out.println(tabulation(grid));
    }

//    public static int minimumOperations(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] dp = new int[m][10];
//        for(int[] arr : dp) Arrays.fill(arr, -1);
//        int min = Integer.MAX_VALUE ;
//        for(int i = 0 ; i < 10 ; i++){
//            min = Math.min(min,memo(grid,0,i,dp));
//        }
//        return min;
//
//    }
//    public static int memo(int[][] grid,int j , int prev,int[][] dp){
//        int n = grid.length, m = grid[0].length;
//
//        if(j >= m)return 0;
//
//        if(dp[j][prev] != -1)return dp[j][prev];
//
//        int min = Integer.MAX_VALUE, cost = 0;
//        for(int i = 0 ; i < n ;i++){
//            if(grid[i][j] != prev){
//                cost++;
//            }
//        }
//        for(int digit = 0 ;digit < 10; digit++){
//            if(prev != digit){
//                min = Math.min(min,cost + memo(grid,j + 1,digit,dp));
//            }
//        }
//        return dp[j][prev] = min;

//    }
    public static int minimumOperations(int[][] grid) {
        int m = grid[0].length;

        int[][] dp = new int[m][10];

        for(int[] arr : dp)Arrays.fill(arr,-1);

        return memo(grid,0,-1,dp);
    }
    public static int memo(int[][] grid,int col, int prevDigit ,int[][] dp){
        if(col >= grid[0].length)return 0;

        if(prevDigit != -1 && dp[col][prevDigit] != -1)return dp[col][prevDigit];

        int min = Integer.MAX_VALUE;
        for(int digit = 0; digit <= 9; digit++){
            if(digit == prevDigit)continue;
            int cost = 0;
            for(int i = 0; i < grid.length ;i++){
                if(grid[i][col] != digit){
                    cost++;
                }
            }
            min = Math.min(min,cost + memo(grid,col + 1,digit,dp));
        }


        if(prevDigit != -1)return dp[col][prevDigit] = min;
        return min;
    }

    public static int tabulation(int[][] grid){
        int m = grid[0].length;
        int[][] dp = new int[m + 1][10];
        for(int col = m -1 ; col >= 0; col--){
            for(int prevDigit = 0; prevDigit <= 9; prevDigit++){
                int min = Integer.MAX_VALUE;
                for(int digit = 0; digit <= 9; digit++){
                    if(digit == prevDigit)continue;
                    int cost = 0;
                    for(int i = 0; i < grid.length ;i++){
                        if(grid[i][col] != digit){
                            cost++;
                        }
                    }
                    min = Math.min(min,cost + dp[col + 1][digit]);
                }
                dp[col][prevDigit] = min;
            }
        }

        int res = Integer.MAX_VALUE;
        for(int digit = 0 ; digit <= 9; digit++){
            res = Math.min(res,dp[0][digit]);
        }
        return res;
    }

}
