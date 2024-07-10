package LCVirtualContests.Biweekly130;

import java.util.*;

public class MaxPointInsideTheSquare {
    public static void main(String[] args) {
        int[][] points = {{-1000000000,-1000000000}, {-1000000000,1000000000}};
        String s = "zy";
        System.out.println(maxPointsInsideSquare(points,s));
    }
    public static int maxPointsInsideSquare(int[][] points, String s) {
        int low = 0 , high = 1000000001;
        int ans = 0;
        while(low < high){
            int mid = low + ( high - low)/2;
            int count = isPossible(points,s,mid);
            ans = Math.max(ans,count);
            if(count != -1){
                low = mid + 1;
            }else high = mid;
        }

        return ans;
    }
    public static int isPossible(int[][] points,String s, int len){
        int count = 0;
        int[] freq = new int[26];
        for (int i = 0; i < points.length; i++) {
            int p1 = Math.abs(points[i][0]);
            int p2 = Math.abs(points[i][1]);
            int p = Math.max(p1,p2);
            if(p > len)continue;
            int index = s.charAt(i) - 'a';
            if(freq[index]++ > 0)return -1;
            count++;
        }
        return count;
    }

    public static int maxPointsInsideSquare1(int[][] points, String s) {
        TreeMap<Integer, List<Character>> distanceMap = new TreeMap<>();
        //store all the square coordinates with corresponding character associated with that coordinate in sorted manner
        for (int i = 0; i < points.length; i++) {
            int maxCoord = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            distanceMap.putIfAbsent(maxCoord, new ArrayList<>());
            distanceMap.get(maxCoord).add(s.charAt(i));
        }
        int res = 0;

        Set<Character> set = new HashSet<>();
        for(int key : distanceMap.keySet()){
            List<Character> list = distanceMap.get(key);
            int size = list.size();
            for(int i = 0 ; i < size; i++){
                char c = list.get(i);
                if(set.contains(c))return res;
                else set.add(c);
            }
            res += size;
        }
        return res;
    }
    public static int maxPointsInsideSquare2(int[][] points, String s) {//most optimal
        //this approach is of idea that we find nearest two points from the origin for every character :)
        //2nd occurence of any character will be my bottleneck
        HashMap<Character, Integer> minLens = new HashMap<>();
        int secondMin = Integer.MAX_VALUE, count = 0;

        for (int i = 0; i < points.length; ++i) {
            int len = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            char c = s.charAt(i);

            if (!minLens.containsKey(c)) {
                minLens.put(c, len);
            } else if (len < minLens.get(c)) {
                secondMin = Math.min(minLens.get(c), secondMin);
                minLens.put(c, len);
            } else {
                secondMin = Math.min(len, secondMin);
            }
        }

        for(int len : minLens.values()) {
            if(len < secondMin) {
                count++;
            }
        }

        return count;
    }
}
