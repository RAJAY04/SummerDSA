package DailyChallenge;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] to_delete = {3,5};
        List<TreeNode> list = delNodes(root,to_delete);
        for(TreeNode node : list){
            System.out.println(node.val);
        }
    }
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int num : to_delete)set.add(num);
        List<TreeNode> list = new ArrayList<>();
        dfs(root,set,list);
        //if the root is not to be deleted then we add it to the list , because the root will be the part of the forest
        if(!set.contains(root.val))list.add(root);
        return list;
    }
    public static TreeNode dfs(TreeNode root , Set<Integer> toDelete,List<TreeNode> forest){
        if(root == null)return null;

        root.left = dfs(root.left,toDelete,forest);
        root.right = dfs(root.right,toDelete,forest);
        //we go depth first and while comming back we do our work of deleting the nodes
        //because if we delete first then we will lose the reference to the children of the node
        if(toDelete.contains(root.val)){
            if(root.left != null)forest.add(root.left);
            if(root.right != null)forest.add(root.right);
            return null;//for the parent node which is calling this node as left or right child it will remove the reference to this node
        }
        return root;//if the node is not to be deleted then we return the node
    }
}
