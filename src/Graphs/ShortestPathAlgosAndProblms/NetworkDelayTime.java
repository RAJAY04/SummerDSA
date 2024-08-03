package Graphs.ShortestPathAlgosAndProblms;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        queue.add(new Pair(k, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int dist = current.weight;

            if (dist > distance[node]) continue;

            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int wt = p.weight;
                if (wt + dist < distance[adjNode]) {
                    distance[adjNode] = wt + dist;
                    queue.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, distance[i]);
        }

        return res;
    }
}
