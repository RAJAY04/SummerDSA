package DailyChallenge;

import Graphs.ShortestPathAlgosAndProblms.DikstrasUsingPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
    public static void main(String[] args) {
        FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance obj = new FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance();
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(obj.findTheCity(n,edges,distanceThreshold));
    }
    class Pair {
        int distance;
        int node;
        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int fromNode = edge[0];
            int toNode = edge[1];
            int edgeWeight = edge[2];
            adj.get(fromNode).add(new Pair(edgeWeight, toNode));
            adj.get(toNode).add(new Pair(edgeWeight, fromNode)); // Assuming undirected graph
        }

        int minCity = -1;
        int minReachableCities = n;

        for (int i = 0; i < n; i++) {
            int reachableCities = dijkstra(n, adj, i, distanceThreshold);
            if (reachableCities <= minReachableCities) {
                minReachableCities = reachableCities;
                minCity = i;
            }
        }

        return minCity;
    }

    private int dijkstra(int n, List<List<Pair>> adj, int startNode, int distanceThreshold) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] distance = new int[n];
        Arrays.fill(distance, (int) (1e9));
        distance[startNode] = 0;
        priorityQueue.add(new Pair(0, startNode));

        while (!priorityQueue.isEmpty()) {
            int node = priorityQueue.poll().node;
            for (Pair edge : adj.get(node)) {
                int adjNode = edge.node;
                int wt = edge.distance;
                if (distance[node] + wt < distance[adjNode]) {
                    distance[adjNode] = distance[node] + wt;
                    priorityQueue.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }

        int reachableCities = 0;
        for (int dist : distance) {
            if (dist <= distanceThreshold) {
                reachableCities++;
            }
        }

        return reachableCities;
    }
}
