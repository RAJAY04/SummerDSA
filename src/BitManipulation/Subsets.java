package BitManipulation;

import java.util.ArrayList;
import java.util.List;
//every number occurs 3 times, one occurs one time , find that number
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();

        for(int num = 0 ; num < subsets ; num++){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                System.out.println(num & ( 1 << i));
                if((num & ( 1 << i)) != 0){
                    temp.add(nums[i]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
