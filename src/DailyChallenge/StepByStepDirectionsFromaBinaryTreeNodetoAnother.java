package DailyChallenge;

import java.lang.reflect.GenericDeclaration;

public class StepByStepDirectionsFromaBinaryTreeNodetoAnother {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(getDirections(root, 5, 1)); // Should print "U"
        System.out.println(getDirections(root, 5, 4)); // Should print "LR"
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = lca(root, startValue, destValue);
        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToEnd = new StringBuilder();
        dfs(LCA, startValue, destValue, new StringBuilder(), lcaToStart, lcaToEnd);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lcaToStart.length(); i++) {
            res.append('U');
        }
        res.append(lcaToEnd);
        return res.toString();
    }

    public static void dfs(TreeNode root, int p, int q, StringBuilder sb, StringBuilder lcaToStart, StringBuilder lcaToEnd) {
        if (root == null) return;

        if (root.val == p) {
            lcaToStart.append(sb.toString());
        } else if (root.val == q) {
            lcaToEnd.append(sb.toString());
        }

        sb.append('L');
        dfs(root.left, p, q, sb, lcaToStart, lcaToEnd);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        dfs(root.right, p, q, sb, lcaToStart, lcaToEnd);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else return root;
    }
//we just do sme thing as in prev approach but after that, we have to remove the extra strings ie root to lca int both strings
    public static String getDirections1(TreeNode root, int startValue, int destValue) {
        StringBuilder lcaToStart = new StringBuilder();//this is rootToStart here
        StringBuilder lcaToEnd = new StringBuilder();//root to end
        dfs1(root, startValue, destValue, new StringBuilder(), lcaToStart, lcaToEnd);

        StringBuilder res = new StringBuilder();
        int n = lcaToStart.length();
        int m = lcaToEnd.length();
        int i = 0, j = 0;

        // Find the common prefix length
        while (i < n && j < m && lcaToStart.charAt(i) == lcaToEnd.charAt(j)) {
            i++;
            j++;
        }

        // Move up from startValue to LCA
        for (int k = i; k < n; k++) {
            res.append('U');
        }

        // Move from LCA to destValue
        res.append(lcaToEnd.substring(j));

        return res.toString();
    }

    public static void dfs1(TreeNode root, int p, int q, StringBuilder sb, StringBuilder lcaToStart, StringBuilder lcaToEnd) {
        if (root == null) return;

        if (root.val == p) {
            lcaToStart.append(sb.toString());
        } else if (root.val == q) {
            lcaToEnd.append(sb.toString());
        }

        sb.append('L');
        dfs1(root.left, p, q, sb, lcaToStart, lcaToEnd);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        dfs1(root.right, p, q, sb, lcaToStart, lcaToEnd);
        sb.deleteCharAt(sb.length() - 1);
    }
}
