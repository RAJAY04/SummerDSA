package DailyChallenge;

import javax.swing.tree.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {

    }
//    int sum = 0;  recursive approach
//    public static TreeNode bstToGst(TreeNode root) {
//        if(root != null){
//            bstToGst(root.right);
//            sum += root.val;
//            root.val = sum;
//            bstToGst(root.left);
//        }
//        return root;
//    }

//    public TreeNode bstToGst(TreeNode root) {  iterative code very imp for interviews
//        int sum = 0;
//        Stack<TreeNode> st = new Stack<>();
//        TreeNode node = root;
//        while(node != null || !st.isEmpty()){
//            while(node != null){
//                st.push(node);
//                node = node.right;
//            }
//
//            node = st.pop();
//            sum += node.val;
//            node.val = sum;
//
//            node = node.left;
//        }
//        return root;
//    }

//    public TreeNode bstToGst(TreeNode root) {  //morris traversal
//        int sum = 0;
//        TreeNode node = root;//make a reference so that root is unchanged to be returend at end
//        while(node != null){//main condition
//            TreeNode post = node.right;//we do reverse inorder so do rev of morris in inorder
//            if(post == null){//if there is no right node available
//                sum += node.val;
//                node.val = sum;
//                node = node.left;
//            }else{//there is a right node available
//                TreeNode postExtremeLeft = node.right;//find the extreme left of just right
//                while(postExtremeLeft.left != null && postExtremeLeft.left != node){
//                    postExtremeLeft = postExtremeLeft.left;
//                }
//                if(postExtremeLeft.left == null){//there was no link means make a link
//                    postExtremeLeft.left = node;
//                    node = node.right;
//                }else{//there is already a link mean remove the link and do the job
//                    postExtremeLeft.left = null;
//                    sum += node.val;
//                    node.val = sum;
//                    node = node.left;
//                }
//            }
//        }
//        return root;
//    }
}
