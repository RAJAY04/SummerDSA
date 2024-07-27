package Graphs.ShortestPathAlgosAndProblms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class DikstrasUsingSET {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>());
        adj.get(0).get(0).add(1);
        adj.get(0).get(0).add(2);
        adj.get(0).add(new ArrayList<>());
        adj.get(0).get(1).add(3);
        adj.get(0).get(1).add(1);
        adj.get(1).add(new ArrayList<>());
        adj.get(1).get(0).add(2);
        adj.get(1).get(0).add(4);
        adj.get(2).add(new ArrayList<>());
        adj.get(2).get(0).add(3);
        adj.get(2).get(0).add(5);
        adj.get(3).add(new ArrayList<>());
        adj.get(3).get(0).add(4);
        adj.get(3).get(0).add(3);
    }
    static class Pair implements Comparable<Pair>{
        int distance;
        int node;
        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.distance == o.distance)return this.node - o.node;
            return this.distance - o.distance;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        Set<Pair> set = new TreeSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist,(int)(1e9));
        dist[S] = 0;
        set.add(new Pair(0,S));

        while (!set.isEmpty()) {
            Pair p = set.iterator().next();
            set.remove(p);
            int distance = p.distance;
            int node = p.node;
            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int wt = edge.get(1);
                if (distance + wt < dist[adjNode]) {
                    Pair adjPair = new Pair(dist[adjNode],adjNode);
                    set.remove(adjPair);
                    dist[adjNode] = distance + wt;
                    set.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        for(int i = 0 ; i < V ;i++){
            if(dist[i] == (int)(1e9)){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
