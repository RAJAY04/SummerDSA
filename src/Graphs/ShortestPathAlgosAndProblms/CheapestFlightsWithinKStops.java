package Graphs.ShortestPathAlgosAndProblms;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
        int src = 0;
        int dst = 4;
        int k = 1;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    //dont use priority queue, just use a simple queue, pq gives TLE
    //we dont need PQ because stops increase constantly +1,+1 like this soo this is basically bfs
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int wt = flights[i][2];
            adj.get(from).add(new Pair(to, wt));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int) (1e9));
        distance[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, 0}); // {current node, current cost, stops}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1];
            int stops = current[2];

            if (stops > k) continue;

            for (Pair adjPair : adj.get(node)) {
                int adjNode = adjPair.node;
                int adjCost = adjPair.distance;

                if (cost + adjCost < distance[adjNode]) {
                    distance[adjNode] = cost + adjCost;
                    queue.add(new int[]{adjNode, cost + adjCost, stops + 1});
                }
            }
        }

        return distance[dst] == (int) (1e9) ? -1 : distance[dst];
    }
}
