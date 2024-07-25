package Graphs.TopologicalSortandProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInDirectGusingBFS {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(3).add(4);
        System.out.println(isCycle(V,adj));
    }
    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree = new int[V];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < V ; i++){
            for(int node : adj.get(i)){
                inDegree[node]++;
            }
        }

        for(int i = 0 ; i < V ; i++){
            if(inDegree[i] == 0)queue.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);
            for(int neighbours : adj.get(node)){
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0)queue.add(neighbours);
            }
        }
        if(V == topo.size())return false;
        return true;
    }
}
