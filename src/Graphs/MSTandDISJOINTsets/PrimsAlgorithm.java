package Graphs.MSTandDISJOINTsets;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int V = 5;
        int E = 5;
        List<List<int[]>> adj = List.of(
            List.of(new int[]{1, 2}, new int[]{2, 3}),
            List.of(new int[]{0, 2}, new int[]{3, 4}),
            List.of(new int[]{0, 3}, new int[]{3, 5}),
            List.of(new int[]{1, 4}, new int[]{2, 5}),
            List.of(new int[]{3, 5}, new int[]{2, 4})
        );
        System.out.println(spanningTree(V, E, adj));
    }

    static class Pair{
        int wt ;
        int node ;
        Pair(int wt,int node){
            this.wt = wt;
            this.node = node;
        }
    }
    //Notes for self!
    //Required data structures
    //1. Min heap
    //2. Visited array
    //3. Mst list that will store all the edges that are a part of MST
    //
    //Datatypes of our data structures
    //Visited array => int
    //Mst list =>  (weight , node name , node parent)
    //
    //
    //
    //Steps
    //1. Mark the visited array as 0 for all the nodes
    //
    //2. Start with 0th node and push
    //(0,0,-1)
    //explanation:  -1 means 0 is the genesis node
    //
    //3. Push all the neighbours of 0 in pq Do not mark them visited  (footnote 1)
    //Since its a min heap the edge with minimum weight will be at the top
    //
    //4. Pick up the top edge , insert it in the mst , mark the picked node as visited , insert all neighbours of picked node into pq
    //
    //5. keep repeating steps 3 and 4 untill all the nodes have been picked up and thats when the algorithm ends
    //
    //
    //footnote:
    //1. why to not mark it visited?
    //in bfs , when we push the element inside a queue we mark it as visited cause that element will be picked up later for sure
    // (algorithm ends only when the queue is empty )
    //but in msts case even if we push the edge into pq , theres no surety that the edge will be picked up .
    // when prims algo ends there are still a few non accepted edges present in the pq hence we only mark it visited once its picked up from pq
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt - b.wt);
        int[] vis = new int[V];
        pq.add(new Pair(0,0)); //we don't need parent just weight/sum is enough

        int sum = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;
            if(vis[node] == 1)continue;
            //we add it to mst
            sum += wt;
            vis[node] = 1;
            for(int[] neighbours : adj.get(node)){
                int adjNode = neighbours[0];
                int adjWt = neighbours[1];
                if(vis[adjNode] == 0){
                    pq.add(new Pair(adjWt,adjNode));
                }
            }
        }
        return sum;
    }
}
