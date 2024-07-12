package Graphs.BFSandDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] ans = floodFill(image, sr, sc, newColor);
        for(int i = 0 ; i < ans.length; i++){
            for(int j = 0 ; j < ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        ans = floodFill1(image,sr,sc,newColor);
        for(int i = 0 ; i < ans.length; i++){
            for(int j = 0 ; j < ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    static class Pair{
        int r ;
        int c;
        Pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(sr,sc));
        int curColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!queue.isEmpty()){
            int r = queue.peek().r;
            int c = queue.peek().c;
            image[r][c] = color;
            for(int i = 0 ; i < 4 ; i++){
                int newRow = r + dx[i];
                int newCol = c + dy[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] != color && image[newRow][newCol] == curColor){
                    queue.add(new Pair(newRow,newCol));
                }
            }
            queue.poll();
        }
        return image;

    }
    public static int[][] floodFill1(int[][] image,int sr, int sc,int color){
        int curColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        dfs(image,sr,sc,color,curColor);
        return image;
    }
    public static void dfs(int[][] image,int r,int c,int color,int curColor){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != curColor || image[r][c] == color)return;
        image[r][c] = color;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i = 0 ; i < 4; i++){
            dfs(image,r + dx[i], c + dy[i],color,curColor);
        }
    }
}
