package DailyChallenge;

import com.sun.source.tree.Tree;

import java.util.*;

public class CreateBinaryTreeFromDescription {
    public static void main(String[] args) {
        int[][] descriptions = {
                {1,2,0},
                {2,3,0},
                {4,5,0},
                {5,6,0}
        };
        System.out.println(createBinaryTree(descriptions));
    }

     static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for(int[] arr : descriptions){
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            childSet.add(child);
            TreeNode node = map.getOrDefault(parent,new TreeNode(parent));

            if(isLeft == 1){
                node.left = map.getOrDefault(child,new TreeNode(child));
                map.put(child,node.left);
            }else{
                node.right = map.getOrDefault(child,new TreeNode(child));
                map.put(child,node.right);
            }
            map.put(parent,node);
        }

        int nodeVal = -1;
        for(int[] arr : descriptions){
            if(!childSet.contains(arr[0])){
                nodeVal = arr[0];
                break;
            }
        }
        return map.getOrDefault(nodeVal,null);
    }
    public static TreeNode createBinaryTree1(int[][] descriptions) {
        Set<Integer> childSet = new HashSet<>();
        Set<Integer> paerntSet = new HashSet<>();
        Map<Integer, List<Integer>> descMap = new HashMap<>();
        int n =  descriptions.length;
        for(int i = 0 ; i < n ;i++){
            childSet.add(descriptions[i][1]);
            paerntSet.add(descriptions[i][0]);

            List<Integer> indices = descMap.getOrDefault(descriptions[i][0],new ArrayList<>());
            indices.add(i);
            descMap.put(descriptions[i][0],indices);
        }
        int rootVal = -1;
        for(int num : paerntSet){
            if(!childSet.contains(num)){
                rootVal = num;
                break;
            }
        }

        if (rootVal == -1) return null;

        return dfs(rootVal, descriptions, descMap);
    }

    public static TreeNode dfs(int rootVal,int[][] descriptions,Map<Integer,List<Integer>> map){
        List<Integer> indices = map.getOrDefault(rootVal,null);
        TreeNode root = new TreeNode(rootVal);
        if(indices == null){
            root.left = null;
            root.right = null;
            return root;
        }


        for(int index : indices){
            int childVal = descriptions[index][1];
            int isLeft = descriptions[index][2];

            if(isLeft == 1){
                root.left = dfs(childVal,descriptions,map);
            }else{
                root.right = dfs(childVal,descriptions,map);
            }
        }

        if (root.left == null && root.right == null) {
            root.left = null;
            root.right = null;
        }
        return root;
    }
}
