package Graphs.BFSandDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graphs = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graphs));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] colors = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                queue.add(i);
                vis[i] = true;
                colors[i] = 1;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    int color = colors[node];
                    for(int neighbours : graph[node]){
                        if(vis[neighbours] && colors[neighbours] == color){
                            return false;
                        }else if(!vis[neighbours]){
                            queue.add(neighbours);
                            vis[neighbours] = true;
                            colors[neighbours] = color == 1 ? 2 : 1;
                        }
                    }
                }
            }
        }
        return true;
    }
}
