package dp.dp2D;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
        System.out.println(tabulation(triangle));
        System.out.println(spaceOptimisation(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp= new int[row][row];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return memo(triangle,0,0,dp);
    }

    public static int memo(List<List<Integer>> triangle,int row , int index , int[][] dp){
        if(row == triangle.size() - 1)return triangle.get(row).get(index);

        if(dp[row][index] != -1)return dp[row][index];

        int down, diag = 0;
        down = memo(triangle,row + 1, index, dp) + triangle.get(row).get(index);

        diag = memo(triangle,row + 1 , index + 1, dp) + triangle.get(row).get(index);

        return dp[row][index] = Math.min(down,diag);
    }

    public static int tabulation(List<List<Integer>> triangle){
        int row = triangle.size();
        int[][] dp = new int[row][row];
        int up = Integer.MAX_VALUE, diag = Integer.MAX_VALUE;
        for(int i = row- 1; i >= 0; i--){
            for(int j = 0 ; j <= i ; j++){
                if(i == row - 1){
                    dp[i][j] = triangle.get(i).get(j);
                }else{
                    up = triangle.get(i).get(j) + dp[i + 1][j];
                    diag = triangle.get(i).get(j) + dp[i + 1][j + 1];
                    dp[i][j] = Math.min(up,diag);
                }
            }
        }
        return dp[0][0];

    }

    public static int spaceOptimisation(List<List<Integer>> triangle){
        int row = triangle.size();
        int[] dp = new int[row];
        int up = Integer.MAX_VALUE, diag = Integer.MAX_VALUE;
        for(int i = row- 1; i >= 0; i--){
            for(int j = 0 ; j <= i ; j++){
                if(i == row - 1){
                    dp[j] = triangle.get(i).get(j);
                }else{
                    up = triangle.get(i).get(j) + dp[j + 1];
                    diag = triangle.get(i).get(j) + dp[j];
                    dp[j] = Math.min(up,diag);
                }
            }
        }
        return dp[0];

    }
}
