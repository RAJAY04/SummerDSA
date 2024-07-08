package Graphs.BFSandDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int provice = 0;
        for(int i = 0 ; i < n ; i++){
            if(visited[i] != 1){
                bfs(isConnected,visited,i);
                provice++;
            }
        }
        return provice;
    }
    public static void bfs(int[][] isConnected , int[] visited, int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = 1;
        while(!q.isEmpty()){
            int curNode = q.poll();
            for(int i = 0; i < isConnected.length; i++){
                if(i == node)continue;
                if(isConnected[curNode][i] == 1 && visited[i] != 1){
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
    }

    public static int findCircleNum1(int[][] isConnected) {//using dfs
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                province++;
            }
        }

        return province;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
