package Graphs.ShortestPathAlgosAndProblms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,10,6,7,9,10,4,9}};
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] distance = new int[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int[] arr : distance)Arrays.fill(arr,(int)(1e9));
        distance[0][0] = 1;
        queue.add(new int[]{0,0,0});

        int res = Integer.MAX_VALUE;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!queue.isEmpty()){
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            int effort = queue.poll()[2];
            if(row == n - 1 && col == m - 1){
                res = Math.min(effort,res);
            }
            for(int i = 0 ; i < 4; i++){
                int curRow = row + dx[i];
                int curCol = col + dy[i];
                if(curRow >= 0 && curCol >= 0 && curRow < n && curCol < m){
                    int curEffort = Math.abs(heights[row][col] - heights[curRow][curCol]);
                    if(curEffort < distance[curRow][curCol]){
                        distance[curRow][curCol] = curEffort;
                        queue.add(new int[]{curRow,curCol,Math.max(curEffort,effort)});
                    }
                }
            }
        }
        return res;
    }
}
