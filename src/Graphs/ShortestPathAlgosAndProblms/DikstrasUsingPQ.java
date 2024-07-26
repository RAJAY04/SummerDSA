package Graphs.ShortestPathAlgosAndProblms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DikstrasUsingPQ {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1,2)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2,3)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(3,6)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(4,5)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4,1)));
        //drawing the graph will look like this
        // 0 -- 1 -- 4
        // |    |    |
        // 3 -- 2    |
        //      |    |
        //      6 -- 5
        int[] distances = dijkstra(V,adj,0);
        for (int distance : distances) {
            System.out.print(distance + " ");
        }
    }
    static class Pair{
        int distance;
        int node;
        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a,b)->a.distance - b.distance);
        int[] dist = new int[V];
        Arrays.fill(dist,(int)(1e9));
        dist[S] = 0;
        priorityQueue.add(new Pair(0,S));

        while (!priorityQueue.isEmpty()) {
            int node = priorityQueue.poll().node;
            //its same if we use dist[node] or pq.poll().distance;
            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int wt = edge.get(1);
                if (dist[node] + wt < dist[adjNode]) {
                    dist[adjNode] = dist[node] + wt;
                    priorityQueue.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
