package DailyChallenge;

import com.sun.source.tree.Tree;

import java.awt.event.TextEvent;
import java.util.ArrayList;
import java.util.List;

public class NumberofGoodLeafNodesPairs {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(countPairs(root,3));
        //we can optimise this by using map instead of list, as we have freq of ans we can multiply
    }

    static int ans = 0;

    public static int countPairs(TreeNode root, int distance) {
        ans = 0;//initialise it inside, else wrong ans bcz it dosent reset to 0 when call funcin again

        dfs(root, distance);
        return ans;
    }

    public static List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            return new ArrayList<>(List.of(1));
        }

        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);

        for (int l : left) {
            for (int r : right) {
                if (l + r <= distance) {
                    ans++;
                }
            }
        }

        List<Integer> temp = new ArrayList<>();
        for (int l : left) {
            if (l + 1 < distance) {
                temp.add(l + 1);
            }
        }
        for (int r : right) {
            if (r + 1 < distance) {
                temp.add(r + 1);
            }
        }

        return temp;
    }
}
