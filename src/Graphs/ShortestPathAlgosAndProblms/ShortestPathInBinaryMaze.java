package Graphs.ShortestPathAlgosAndProblms;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMaze {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1)return -1;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        vis[0][0] = true;
        while(!queue.isEmpty()){
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            int distance = queue.poll()[2];
            if(r ==  n -1 && c == m - 1)return distance;
            int[] dx = {-1,-1,-1,0,1,1,1,0};
            int[] dy = {-1,0,1,1,1,0,-1,-1};
            for(int i = 0 ; i < 8; i++){
                int row = dx[i] + r;
                int col = dy[i] + c;
                if(row >= 0 && col >= 0 && row < n && col < m && !vis[row][col] && grid[row][col] != 1){
                    vis[row][col] = true;
                    queue.add(new int[]{row,col,distance + 1});
                }
            }
        }
        return -1;
    }
}
