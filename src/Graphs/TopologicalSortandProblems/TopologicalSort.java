package Graphs.TopologicalSortandProblems;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
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
        int[] res = topoSort(V,adj);
        for(int i : res){
            System.out.print(i + " ");
        }
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> res = new Stack<>();
        for(int i = 0 ; i < V ;i++){
            if(!vis[i]){
                dfs(i,adj,res,vis);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while(!res.isEmpty())ans[i++] = res.pop();
        return ans;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> res, boolean[] vis){
        vis[node] = true;
        for(int neighbours : adj.get(node)){
            if(!vis[neighbours]){
                dfs(neighbours,adj,res,vis);
            }
        }
        res.add(node);
    }
}
