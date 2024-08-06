package Graphs.MSTandDISJOINTsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new int[]{1,2});
        adj.get(1).add(new int[]{0,2});

        adj.get(1).add(new int[]{2,3});
        adj.get(2).add(new int[]{1,3});

        adj.get(0).add(new int[]{3,6});
        adj.get(3).add(new int[]{0,6});

        adj.get(3).add(new int[]{4,1});
        adj.get(4).add(new int[]{3,1});

        adj.get(2).add(new int[]{4,4});
        adj.get(4).add(new int[]{2,4});

        System.out.println(spanningTree(V,E,adj));
    }
    static class Edge implements Comparable<Edge>{
        int src ;
        int dest;
        int wt;
        Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.wt - compareEdge.wt;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            for(int[] list : adj.get(i)){
                int adjNode = list[0];
                int wt = list[1];
                Edge temp = new Edge(i,adjNode,wt);
                edges.add(temp);
            }
        }
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(edges);
        int mstWt = 0;
        for(int i = 0 ; i < edges.size(); i++){
            int wt = edges.get(i).wt;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if(ds.findUPar(u) != ds.findUPar(v)){
                mstWt += wt;
                ds.unionBySize(u,v);
            }
        }
        return mstWt;

    }
    static class DisjointSet {

        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findUPar(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node,ulp);
            return ulp;
        }

        public void unionBySize(int u ,int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v)return;

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_v) + size.get(ulp_u));
            }
        }

    }
}
