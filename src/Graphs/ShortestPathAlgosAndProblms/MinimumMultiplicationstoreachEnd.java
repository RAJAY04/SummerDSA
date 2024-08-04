package Graphs.ShortestPathAlgosAndProblms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMultiplicationstoreachEnd {
    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int start = 7;
        int end = 66175;
        System.out.println(minimumMultiplications(arr, start, end));
    }
    static class Pair{
        int node;
        int steps;
        Pair(int node,int steps){
            this.node = node;
            this.steps = steps;
        }
    }
    static int minimumMultiplications(int[] arr, int start, int end) {
        int[] distance = new int[(int)(1e5)];
        int mod = (int)(1e5);

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a,b)->a.steps - b.steps);

        priorityQueue.add(new Pair(start,0));

        while(!priorityQueue.isEmpty()){
            Pair p = priorityQueue.poll();
            int num = p.node;
            int steps = p.steps;
            if(num == end)return steps;

            for(int n : arr){
                int newNum = (n * num) % mod;
                if(distance[newNum] > steps + 1){
                    distance[newNum] = steps + 1;
                    priorityQueue.add(new Pair(newNum,distance[newNum]));
                }
            }
        }
        return -1;
    }
}
