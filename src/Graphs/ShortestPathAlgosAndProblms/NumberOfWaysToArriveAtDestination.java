package Graphs.ShortestPathAlgosAndProblms;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 4, 1}, {4, 5, 2}, {5, 6, 3}};
        System.out.println(countPaths(n, roads));
    }

    static class Pair{
        int node;
        long weight;
        Pair(int node, long weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            long wt = road[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] distance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a.weight));
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int node = p.node;
            long wt = p.weight;

            for (Pair adjP : adj.get(node)) {
                int adjNode = adjP.node;
                long adjWt = adjP.weight;
                if (wt + adjWt < distance[adjNode]) {
                    distance[adjNode] = wt + adjWt;
                    queue.add(new Pair(adjNode, distance[adjNode]));
                    ways[adjNode] = ways[node];
                } else if (wt + adjWt == distance[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % ((int) 1e9 + 7);
                }
            }
        }

        return ways[n - 1] % ((int) 1e9 + 7);
    }
}
