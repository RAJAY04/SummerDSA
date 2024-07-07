package LeetCodeContests.Weekly405;

import java.util.HashMap;
import java.util.Map;

public class CountSubMatricesWithEqualFrequencyXandY {
    public static void main(String[] args) {
//        char[][] grid = {{'X','Y','.'},{'Y','X','.'},{'X','Y','.'}};
        char[][] grid = {{'.','.'},{'.','.'}};
        System.out.println(numberOfSubmatrices(grid));
    }
    public static int numberOfSubmatrices(char[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[][] xDp = new int[n + 1][m + 1];
        int[][] yDp = new int[n + 1][m + 1];

        int ans = 0;
        for(int i = 1;  i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                xDp[i][j] = (xDp[i - 1][j] + xDp[i][j - 1]) - xDp[i - 1][j - 1];//- because we subtract the reduntant value
                yDp[i][j] = (yDp[i - 1][j] + yDp[i][j - 1]) - yDp[i - 1][j - 1];
                //we see that i-1,j value depends on i-1,j-1 and also i,j-1 depends on i-1,j-1 , so if i-1,j-1 was 1,which means we add it twice.
                //dry run to understand
                if(grid[i - 1][j - 1] == 'X')xDp[i][j]++;
                else if(grid[i - 1][j - 1] == 'Y')yDp[i][j]++;

                if(xDp[i][j] == yDp[i][j] && xDp[i][j] != 0)ans++;
            }
        }
        return ans;
    }
}
