package DailyChallenge;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BalanceaBinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        //DSW algorithm
        if (root == null) return null;

        TreeNode vineHead = new TreeNode(0);
        vineHead.right = root;
        TreeNode cur = vineHead;

        // Create a "vine" (right-skewed tree)
        while (cur.right != null) {
            if (cur.right.left != null) {
                rightRotate(cur, cur.right);
            } else {
                cur = cur.right;
            }
        }

        // Count the number of nodes
        int nodeCount = 0;
        cur = vineHead.right;
        while (cur != null) {
            nodeCount++;
            cur = cur.right;
        }

        // Compute the number of leaves in the complete tree
        int m = largestPowerOf2LessThan(nodeCount + 1) - 1;

        // Perform the initial set of rotations
        makeRotations(vineHead, nodeCount - m);

        // Perform rotations in decreasing order of subtree sizes
        while (m > 1) {
            m /= 2;
            makeRotations(vineHead, m);
        }

        TreeNode balancedRoot = vineHead.right;
        return balancedRoot;
    }

    private static int largestPowerOf2LessThan(int n) {
        int power = 1;
        while (power * 2 < n) {
            power *= 2;
        }
        return power;
    }

    private static void rightRotate(TreeNode parent, TreeNode node) {
        if (node == null || node.left == null) return;
        TreeNode temp = node.left;
        node.left = temp.right;
        temp.right = node;
        parent.right = temp;
    }

    private static void leftRotate(TreeNode parent, TreeNode node) {
        if (node == null || node.right == null) return;
        TreeNode temp = node.right;
        node.right = temp.left;
        temp.left = node;
        parent.right = temp;
    }

    private static void makeRotations(TreeNode vineHead, int count) {
        TreeNode current = vineHead;
        for (int i = 0; i < count; i++) {
            if (current.right == null) break;
            TreeNode temp = current.right;
            leftRotate(current, temp);
            current = current.right;
        }
    }

    public static void main(String[] args) {
        BalanceaBinarySearchTree tree = new BalanceaBinarySearchTree();

        TreeNode root = null;
        root = tree.insert(root, 50);
        root = tree.insert(root, 30);
        root = tree.insert(root, 70);
        root = tree.insert(root, 20);
        root = tree.insert(root, 40);
        root = tree.insert(root, 60);
        root = tree.insert(root, 80);

        System.out.println("In-order traversal before balancing:");
        tree.inorderTraversal(root);
        System.out.println();

        // Balance the BST
        root = tree.balanceBST(root);

        System.out.println("In-order traversal after balancing:");
        tree.inorderTraversal(root);
        System.out.println();
    }

    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
