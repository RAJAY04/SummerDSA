package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,ans,list,0);
        return ans;
    }
    public static void helper(int[] nums,List<List<Integer>> ans , List<Integer> list ,int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        helper(nums,ans,list,index + 1);
        list.remove(list.size() - 1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        helper(nums,ans , list,index + 1);
    }
}
