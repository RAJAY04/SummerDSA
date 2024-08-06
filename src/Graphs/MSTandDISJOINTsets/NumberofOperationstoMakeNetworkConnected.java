package Graphs.MSTandDISJOINTsets;

import java.util.*;

public class NumberofOperationstoMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0,1},{0,2},{1,2}};
        System.out.println(makeConnected1(n, connections));
        System.out.println(makeConnected(n, connections));
    }

    //this is the easiest solution
    public static int makeConnected1(int n, int[][] connections) {
        if(connections.length < n - 1)return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++)adj.add(new ArrayList<>());

        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int components = 0;
        for(int i = 0 ; i < n; i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                components++;
            }
        }

        return components - 1;
    }

    public static void dfs(int node,List<List<Integer>> adj,boolean[] vis){
        vis[node] = true;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode])dfs(adjNode,adj,vis);
        }
    }

    static class DisjointSet{
        int[] parent;
        int[] size;
        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0 ; i < n; i++){
                size[i] = 1;
                parent[i] = i;
            }
        }

        int findUltimateParent(int node){
            if(parent[node] == node)return node;
            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionBySize(int u ,int v){
            int ult_parent_u = findUltimateParent(u);
            int ult_parent_v = findUltimateParent(v);

            if(size[ult_parent_u] < size[ult_parent_v]){
                parent[ult_parent_u] = parent[ult_parent_v];
                size[ult_parent_v] += size[ult_parent_u];
            }else{
                parent[ult_parent_v] = parent[ult_parent_u];
                size[ult_parent_u] += size[ult_parent_v];
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            if(ds.findUltimateParent(u) != ds.findUltimateParent(v)){
                ds.unionBySize(u,v);
            }else extraEdges++;
        }

        int components = 0;
        for(int i = 0 ;i < n; i++){
            if(ds.parent[i] == i)components++;
        }
        if(extraEdges >= components - 1)return components - 1;
        return -1;
    }
}
