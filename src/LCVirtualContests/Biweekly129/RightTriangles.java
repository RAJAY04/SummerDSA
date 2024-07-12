package LCVirtualContests.Biweekly129;

public class RightTriangles {
    public static void main(String[] args) {
        int[][] grid = {{0, 0}, { 1, 1}, { 1, 0},{0,1}};
        System.out.println(numberOfRightTriangles(grid));
    }

    public static long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long ans = 0;
        int[] rowSum = new int[n];//no of rows = n remember
        int[] colSum = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += grid[i][j];//great method
                colSum[j] += grid[i][j];
            }
        }


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;j < m ; j++){
                if(grid[i][j] == 1){
                    ans += (rowSum[i] - 1) * (colSum[j] - 1);
                }
            }
        }
        return ans;
    }
}
