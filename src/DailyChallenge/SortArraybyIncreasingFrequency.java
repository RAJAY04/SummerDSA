package DailyChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        int[] res = frequencySort(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] frequencySort1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b) -> {
            return( map.get(a) == map.get(b))?b - a: map.get(a) - map.get(b);
        });

        int[] res = new int[nums.length];
        int i = 0;
        for(int num : list){
            for(int j = 0 ; j < map.get(num); j++){
                res[i++] = num;
            }
        }
        return res;


    }
    public static int[] frequencySort(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Map<Integer,Integer> map = new HashMap();

        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }

        Arrays.sort(arr,(ele1,ele2)->{
            int freq1 = map.get(ele1);
            int freq2 = map.get(ele2);

            if(freq1 == freq2){
                return ele2 - ele1;
            }else return freq1 - freq2;
        });

        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            res[i] = arr[i];
        }
        return res;
    }
}
