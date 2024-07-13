package Graphs.BFSandDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix01 {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ans = updateMatrix(mat);
        for(int i = 0 ; i < ans.length ; i++){
            for(int j = 0 ; j < ans[0].length ; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    static class Pair{
        int x ;
        int y ;
        int distance;
        Pair(int x , int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> queue = new ArrayDeque<>();
        int[][] vis = new int[n][m];
        int[][] res = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;j < m ; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    queue.add(new Pair(i,j,0));
                }
            }
        }

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int distance = p.distance;
            res[p.x][p.y] = distance;

            for(int i = 0; i < 4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x >=0 && x < n && y >= 0 && y < m && vis[x][y] != 1){
                    queue.add(new Pair(x,y,distance + 1));
                    vis[x][y] = 1;
                }
            }
        }
        return res;
    }
}
