package DailyChallenge;

import java.util.*;

public class KthDistinctStringinanArray {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new LinkedHashMap<>();
        for(String s : arr){
            if(map.containsKey(s)){
                map.put(s,map.get(s) + 1);
            }else map.put(s,1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                k--;
            }
            if(k == 0)return entry.getKey();
        }
        return "";
    }
}
