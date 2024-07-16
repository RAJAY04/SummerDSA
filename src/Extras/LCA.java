package Extras;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;
        TreeNode p1 = new TreeNode(6);
        TreeNode q1 = new TreeNode(2);
        p.left = p1;
        p.right = q1;
        TreeNode p2 = new TreeNode(7);
        TreeNode q2 = new TreeNode(4);
        q1.left = p2;
        q1.right = q2;
        TreeNode p3 = new TreeNode(0);
        TreeNode q3 = new TreeNode(8);
        q.left = p3;
        q.right = q3;
        System.out.println(lowestCommonAncestor(root,p3,q2).val);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //if a nodes both left and right returns null that is LCA
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if((left != null && right != null) || root == p || root == q){
            return root;
        }
        return (left == null) ? right : left;
    }

}
