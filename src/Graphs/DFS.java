package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        System.out.println(dfsOfGraph(V,adj));
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0,adj,visited,res);
        return res;
    }
    public static void dfs(int node ,ArrayList<ArrayList<Integer>> adj,boolean[] visited,List<Integer> list){
        visited[node] = true;
        list.add(node);
        for(Integer it : adj.get(node)){
            if(!visited[it])
                dfs(it,adj,visited,list);
        }
    }
}
