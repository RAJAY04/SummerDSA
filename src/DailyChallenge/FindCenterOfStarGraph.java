package DailyChallenge;

public class FindCenterOfStarGraph {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        int common = 0;
        if (edges[0][0] == edges[1][0]) {
            common = edges[0][0];
        }
        if (edges[0][1] == edges[1][0]) {
            common = edges[0][1];
        }
        if (edges[0][0] == edges[1][1]) {
            common = edges[0][0];
        }
        if (edges[0][1] == edges[1][1]) {
            common = edges[0][1];
        }
        return common;
    }
}
