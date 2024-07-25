package Graphs.TopologicalSortandProblems;

import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
        System.out.println(eventualSafeNodes1(graph));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = graph.length;
        int[] inDegree = new int[n];
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n; i++){
            for(int node : graph[i]){
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> topo = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            if(inDegree[i] == 0)queue.add(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);
            for(int neighbours : adj.get(node)){
                inDegree[neighbours]--;
                if(inDegree[neighbours] == 0){
                    queue.add(neighbours);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }

    public static List<Integer> eventualSafeNodes1(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i < n ; i++){
            if(!vis[i])dfs(graph,i,res,vis,pathVis);
        }
        Collections.sort(res);
        return res;
    }
    public static boolean dfs(int[][] graph,int node,List<Integer> res, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node]= true;

        for(int neighbours : graph[node]){
            if(vis[neighbours] && pathVis[neighbours])return true;
            else if(!vis[neighbours]){
                if(dfs(graph,neighbours,res,vis,pathVis))return true;
            }
        }
        pathVis[node] = false;
        res.add(node);
        return false;
    }
}
