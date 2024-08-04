package Graphs.ShortestPathAlgosAndProblms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgo {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1, -1)));
        edges.add(new ArrayList<>(List.of(0, 2, 4)));
        edges.add(new ArrayList<>(List.of(1, 2, 3)));
        edges.add(new ArrayList<>(List.of(1, 3, 2)));
        edges.add(new ArrayList<>(List.of(1, 4, 2)));
        edges.add(new ArrayList<>(List.of(3, 2, 5)));
        edges.add(new ArrayList<>(List.of(3, 1, 1)));
        edges.add(new ArrayList<>(List.of(4, 3, -3)));
        int S = 0;
        int[] res = bellman_ford(V, edges, S);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int) (1e8));
        distance[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> list : edges) {
                int u = list.get(0);
                int v = list.get(1);
                int wt = list.get(2);
                //if node is reachable and distance is lesser
                if (distance[u] != (int) (1e8) && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }

        }
        //last neg cycle check

        for (ArrayList<Integer> list : edges) {
            int u = list.get(0);
            int v = list.get(1);
            int wt = list.get(2);
            //if node is reachable and distance is lesser
            if (distance[u] != (int) (1e8) && distance[u] + wt < distance[v]) {
                return new int[]{-1};
            }
        }

        return distance;
    }
}
