package Graphs.BFSandDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfEnclaves {
    //both dfs and bfs approach given below

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println(numEnclaves(grid));
        System.out.println(numEnclaves1(grid));


    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(grid, i, 0,visited);
            }
            if (grid[i][m - 1] == 1 && !visited[i][m - 1]) {
                dfs(grid, i, m - 1,visited);
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                dfs(grid, 0, j,visited);
            }
            if (grid[n - 1][j] == 1 && !visited[n - 1][j]) {
                dfs(grid, n - 1, j,visited);
            }
        }

        int remOnes = 0;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    remOnes++;
                }
            }
        }
        return remOnes;
    }
    public static void dfs(int[][] grid,int r , int c, boolean[][] visited){
        if(grid[r][c] == 0)return;
        visited[r][c] = true;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0 ; i < 4; i++){
            int row = r + dx[i];
            int col = c + dy[i];
            if((row >= 0 && col >= 0 && row < grid.length && col < grid[0].length) && !visited[row][col]){
                dfs(grid,row,col,visited);
            }
        }
    }

    public static int numEnclaves1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                int[] temp = {i,0};
                queue.add(temp);
                visited[i][0] = true;
            }
            if (grid[i][m - 1] == 1) {
                int[] temp = {i,m - 1};
                queue.add(temp);
                visited[i][m - 1] = true;
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                int[] temp = {0,j};
                queue.add(temp);
                visited[0][j] = true;
            }
            if (grid[n - 1][j] == 1 && !visited[n - 1][j]) {
                int[] temp = {n - 1,j};
                queue.add(temp);
                visited[n - 1][j] = true;
            }
        }

        while (!queue.isEmpty()){
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            queue.poll();
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            for(int i = 0 ; i < 4; i++){
                int row = r + dx[i];
                int col = c + dy[i];
                if((row >= 0 && col >= 0 && row < grid.length && col < grid[0].length) && !visited[row][col] && grid[row][col] == 1){
                    queue.add(new int[]{row,col});
                    visited[row][col] = true;
                }
            }
        }

        int remOnes = 0;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    remOnes++;
                }
            }
        }
        return remOnes;
    }

}
