package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        System.out.println(bfsOfGraph(V,adj));
    }
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            List<Integer> list = adj.get(node);
            for(int num : list){
                if(!visited[num]){
                    q.add(num);
                    visited[num] = true;
                }
            }
            res.add(node);
        }
        return res;
    }
}
