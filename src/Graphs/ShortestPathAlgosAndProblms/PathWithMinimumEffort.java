package Graphs.ShortestPathAlgosAndProblms;

import java.util.ArrayDeque;
import java.util.Queue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,0});
        vis[0][0] = true;
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            int distance = queue.poll()[2];
            if(r ==  n -1 && c == m - 1)res = Math.min(res,distance);
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            for(int i = 0 ; i < 4; i++){
                int row = dx[i] + r;
                int col = dy[i] + c;
                if(row >= 0 && col >= 0 && row < n && col < m && !vis[row][col] && heights[row][col] != 1){
                    vis[row][col] = true;
                    queue.add(new int[]{row,col,Math.abs(distance - heights[row][col])});
                }
            }
        }
        return res;
    }
}
