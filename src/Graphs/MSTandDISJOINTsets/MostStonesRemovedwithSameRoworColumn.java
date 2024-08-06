package Graphs.MSTandDISJOINTsets;

import java.util.*;

public class MostStonesRemovedwithSameRoworColumn {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
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

            if(ult_parent_v == ult_parent_u)return;
            if(size[ult_parent_u] < size[ult_parent_v]){
                parent[ult_parent_u] = parent[ult_parent_v];
                size[ult_parent_v] += size[ult_parent_u];
            }else{
                parent[ult_parent_v] = parent[ult_parent_u];
                size[ult_parent_u] += size[ult_parent_v];
            }
        }
    }
    public static int removeStones(int[][] stones) {
        int maxRow = 0 , maxCol = 0;
        int n = stones.length;
        for(int i = 0 ; i < n; i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Map<Integer,Integer> stoneNodes = new HashMap<>();

        for(int i = 0 ; i < n; i++){
            int node_row = stones[i][0];
            int node_cols = stones[i][1] + maxRow + 1;
            ds.unionBySize(node_row,node_cols);
            stoneNodes.put(node_row,1);
            stoneNodes.put(node_cols,1);
        }
        int components = 0;
        for (int key : stoneNodes.keySet()) {
            if (ds.findUltimateParent(key) == key) {
                components++;
            }
        }

        return n - components;
    }

    public static int removeStones1(int[][] stones) {
        int maxRow = 0 , maxCol = 0;
        int n = stones.length;
        for(int i = 0 ; i < n; i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        for(int[] stone : stones){
            ds.unionBySize(stone[0],maxRow + 1 + stone[1]);
        }
        Set<Integer> set = new HashSet<>();

        for(int[] stone : stones){
            set.add(ds.findUltimateParent(stone[0]));
        }
        return n - set.size();
    }
}
