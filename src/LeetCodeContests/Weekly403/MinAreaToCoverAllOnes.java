package LeetCodeContests.Weekly403;

public class MinAreaToCoverAllOnes {
    public static void main(String[] args) {
        int[][] grid = {{1,1}};
        System.out.println(minimumArea(grid));
    }
    public static int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int r1 = 0 , r2 = n - 1 , c1 = 0 , c2 = m - 1;
        boolean r1Found = false , r2Found = false, c1Found = false, c2Found = false;
        while(r1 <= r2){
            if(!r1Found){
                for(int i = 0 ; i < m; i++){
                    if(grid[r1][i] == 1){
                        r1Found = true;
                        break;
                    }
                }
                if(!r1Found)
                    r1++;
            }
            if(!r2Found){
                for(int i = 0 ; i < m; i++){
                    if(grid[r2][i] == 1){
                        r2Found = true;
                        break;
                    }
                }
                if(!r2Found)
                    r2--;
            }
            if(r1Found && r2Found)break;
        }
        while(c1 <= c2){
            if(!c1Found){
                for(int i = 0 ; i < n; i++){
                    if(grid[i][c1] == 1){
                        c1Found = true;
                        break;
                    }
                }
                if(!c1Found)
                    c1++;
            }
            if(!c2Found){
                for(int i = 0 ; i < n; i++){
                    if(grid[i][c2] == 1){
                        c2Found = true;
                        break;
                    }
                }
                if(!c2Found)
                    c2--;
            }
            if(c1Found && c2Found)break;
        }
        return ((c2 - c1) + 1) * ((r2 - r1) + 1);
    }
}
