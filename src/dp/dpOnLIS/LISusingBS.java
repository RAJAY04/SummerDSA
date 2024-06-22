package dp.dpOnLIS;

import java.util.ArrayList;
import java.util.List;

public class LISusingBS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        temp.add(nums[0]);
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > temp.get(temp.size() - 1)){
                temp.add(nums[i]);
            }else{
                int index = lowerBound(temp,nums[i]);
                temp.set(index,nums[i]);
            }
        }
        return temp.size();
    }

    public static int lowerBound(List<Integer> list , int num){
        int s = 0 , e = list.size() - 1;
        while( s < e){
            int mid = s + (e - s)/2;
            if(list.get(mid) == num){
                return mid;
            }else if(list.get(mid) > num){
                e = mid;
            }else s = mid + 1;
        }
        return s;
    }
}
