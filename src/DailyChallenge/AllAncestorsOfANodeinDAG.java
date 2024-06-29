package DailyChallenge;

import java.util.ArrayList;
import java.util.List;

public class AllAncestorsOfANodeinDAG {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(getAncestors(n,edges));
    }
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList();
        List<List<Integer>> directChild = new ArrayList();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList());
            directChild.add(new ArrayList());
        }
        for (int[] e: edges)
            directChild.get(e[0]).add(e[1]);
        for (int i = 0; i < n; i++)
            dfs(i, i, ans, directChild);
        return ans;
    }
    private static void dfs(int x, int curr, List<List<Integer>> ans, List<List<Integer>> directChild) {
        for (int ch: directChild.get(curr))
            if(ans.get(ch).size() == 0 || ans.get(ch).get(ans.get(ch).size() - 1) != x) {
                ans.get(ch).add(x);
                dfs(x, ch, ans, directChild);
            }
    }
}
