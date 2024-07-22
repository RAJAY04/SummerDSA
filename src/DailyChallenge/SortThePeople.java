package DailyChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortThePeople {
    public static void main(String[] args) {
        String[] names = {"Alex", "Charlie", "Michael"};
        int[] heights = {1, 3, 2};
        String[] res = sortPeople(names, heights);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new TreeMap<>();
        for(int i = 0 ; i < heights.length; i++){
            map.put(heights[i],names[i]);
        }
        String [] res = new String[heights.length];
        int i = heights.length - 1;
        for(Map.Entry<Integer,String > entry : map.entrySet()){
            res[i--] = entry.getValue();
        }
        return res;
    }
}
