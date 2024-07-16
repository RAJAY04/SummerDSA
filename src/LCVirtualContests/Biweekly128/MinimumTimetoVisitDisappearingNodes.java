//package LCVirtualContests.Biweekly128;
//
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.Queue;
//
//public class MinimumTimetoVisitDisappearingNodes {
//    public static void main(String[] args) {
//        int n = 3;
//        int[][] edges = {{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
//        int[] disappear = {1, 1, 5};
//        int[] res = minimumTime(n, edges, disappear);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }
//    }
//
//    static class Pair {
//        int[] point;
//        int time;
//
//        Pair(int[] point, int time) {
//            this.time = time;
//            this.point = point;
//        }
//    }
//
//    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
//        int[] res = new int[n];
//        Arrays.fill(res, -1);
//        Queue<Pair> queue = new ArrayDeque<>();
//        boolean[] visited = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            if (edges[i][0] == 0) {
//                queue.add(new Pair(edges[i], 0));
//                visited[i] = true;
//            }
//        }
//
//
//        while (!queue.isEmpty()) {
//            int[] pair = queue.peek().point;
//            int curNode = pair[0];
//            int nextNode = pair[1];
//            int curTime = queue.peek().time;
//            int nextTime = pair[2];
//
//            if (disappear[curNode] > curTime) {
//                res[curNode] = curTime;
//            } else res[curNode] = -1;
//
//            if (!visited[nextNode]) {
//                queue.add(new Pair(edges[nextNode], curTime + nextTime));
//                visited[nextNode] = true;
//            }
//            queue.poll();
//        }
//        return res;
//    }
//}
