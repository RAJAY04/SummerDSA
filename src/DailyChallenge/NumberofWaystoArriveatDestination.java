package DailyChallenge;

import Graphs.ShortestPathAlgosAndProblms.NetworkDelayTime;

import java.util.*;

public class NumberofWaystoArriveatDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 4, 1}, {4, 5, 2}, {5, 6, 3}};
        System.out.println(countPaths(n, roads));
    }
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int[] distance = new int[n];
        int[] ways = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int dist = current.weight;
            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int wt = p.weight;
                if (wt + dist < distance[adjNode]) {
                    distance[adjNode] = wt + dist;
                    queue.add(new Pair(adjNode, distance[adjNode]));
                    ways[adjNode] = ways[node];
                } else if (wt + dist == distance[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
