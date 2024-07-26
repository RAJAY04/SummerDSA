package Graphs.ShortestPathAlgosAndProblms;

import java.util.*;

public class ShortestPathInDAGusingTopo {
    public static void main(String[] args) {
        int[][] edges = {
                {0,1,2}, {0,2,1}
        };
        int n = 4;
        int m = 2;
        try {
            int[] distances = shortestPath(n, m, edges);
            for (int distance : distances) {
                System.out.print(distance + " ");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static int[] shortestPath(int N,int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i = 0 ;i < M ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[N];
        for(int i = 0; i < N ; i++){
            if(!vis[i])dfs(i,adj,stack,vis);
        }

        int[] distance = new int[N];
        Arrays.fill(distance,(int)(1e9));//dont fill int max overflow will occur
        distance[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (Pair p : adj.get(node)) {
                int neighbour = p.node;
                int wt = p.weight;
                if (distance[node] + wt < distance[neighbour]) {
                    distance[neighbour] = distance[node] + wt;
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            if(distance[i] == (int)(1e9))distance[i] = -1;
        }
        return distance;

    }

    public static void dfs(int node ,List<List<Pair>> adj, Stack<Integer> stack , boolean[] vis){
        vis[node] = true;

        for(Pair p : adj.get(node)){
            int neighbour = p.node;
            if(!vis[neighbour]){
                dfs(neighbour,adj,stack,vis);
            }
        }
        stack.add(node);
    }
}
