package LCVirtualContests.Biweekly130;

public class CheckIfGridSatisfiesCondition {
    public static void main(String[] args) {
        int[][] grid = {{1,2,1},{2,1,2},{1,2,1}};
        System.out.println(satisfiesConditions(grid));
    }
    public static boolean satisfiesConditions(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean ans = true;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(j + 1 < m && grid[i][j] == grid[i][j + 1]){
                    ans = false;
                }
            }
        }
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(j + 1 < n && grid[j][i] != grid[j + 1][i]){
                    ans = false;
                }
            }
        }
        return ans;
    }

}
