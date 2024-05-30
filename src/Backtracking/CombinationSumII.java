package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum2(candidates, target));
    }
    static List<List<Integer>> ans ;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,temp,0,0);
        return ans;
    }

    public static void helper(int[] candidates, int target, List<Integer> temp, int index, int sum){
        if(sum >= target){
            if(sum == target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i = index; i < candidates.length ;i++){
            if( i > index && candidates[i - 1] == candidates[i])continue;
            temp.add(candidates[i]);
            helper(candidates,target,temp,i+1,sum + candidates[i]);
            temp.remove(temp.size() -1);
        }

    }
}
