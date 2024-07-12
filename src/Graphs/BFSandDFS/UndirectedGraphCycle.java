package Graphs.BFSandDFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class UndirectedGraphCycle {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        System.out.println(isCycle(V,adj));
        System.out.println(isCycle1(V,adj));
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean ans = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans = bfs(i, adj, visited);
                if (ans) return true;
            }
        }
        return false;
    }

    static class Pair {
        int node;
        int source;
        Pair(int node, int source) {
            this.node = node;
            this.source = source;
        }
    }

    public static boolean bfs(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(source, -1));
        visited[source] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int parent = current.source;

            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] && parent != adjNode) {
                    return true;
                } else if (!visited[adjNode]) {
                    queue.add(new Pair(adjNode, node));
                    visited[adjNode] = true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle1(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean ans = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans = dfs(i,-1, adj, visited);
                if (ans) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int node,int parent, ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(int adjNode : adj.get(node)){
            if(!visited[adjNode]){
                if(dfs(adjNode,node,adj,visited))return true;//this line is essential, as left dfs call may return true
            }else{
                if(parent != adjNode)return true;
            }
        }
        return false;
    }
}
