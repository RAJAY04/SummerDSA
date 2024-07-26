package Graphs.ShortestPathAlgosAndProblms;

import java.util.*;

public class ShortestPathInAnUnderectedGraph {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6},
                {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };
        int n = 9;
        int m = 10;
        int src = 0;
        try {
            int[] distances = shortestPath(edges, n, m, src);
            for (int distance : distances) {
                System.out.print(distance + " ");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++)adj.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        distance[src] = 0;

        while(!queue.isEmpty()){
            int node = queue.peek();
            int dis = distance[node];
            for(int neighbours : adj.get(node)){
                if(distance[neighbours] > dis + 1){
                    queue.add(neighbours);
                    distance[neighbours] = dis + 1;
                }
            }
            queue.poll();
        }

        for(int i = 0 ;i < n; i++)if(distance[i] == Integer.MAX_VALUE)distance[i] = -1;

        return distance;
    }
}
