package LCVirtualContests.Weekly388;

import java.util.*;

public class ShortestUncommonSubstringinanArray {
    public static void main(String[] args) {
        String[] arr = {"cab","ad","bad","c"};
        System.out.println(Arrays.toString(shortestSubstrings(arr)));
    }

    public static String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        Map<String, Set<String>> mapSet = new HashMap<>();
        Map<String,List<String>> mapList = new HashMap<>();
        for(String s : arr){
            List<String> list = new ArrayList<>();
            generate(s,list);
            mapList.put(s,list);
            Set<String> set = new HashSet<>();
            for(String str : list)set.add(str);
            mapSet.put(s,set);
        }
        String[] res = new String[n];
        for(int i = 0 ; i < n ; i++){
            String key = arr[i];
            List<String> tempList = mapList.get(key);

            String best = null;
            for(String sub : tempList){
                boolean violation = false;
                for(int j = 0 ; j < n ; j++){
                    if(i == j)continue;
                    Set<String> tempSet = mapSet.get(arr[j]);
                    if(tempSet.contains(sub)){
                        violation = true;
                        break;
                    }
                }
                if(!violation){
                    if(best == null || sub.length() < best.length() || (sub.length() == best.length() && manualCompareTo(sub, best) < 0)){
                        best = sub;
                    }
                }
            }
            if(best == null)
                res[i] = "";
            else res[i] = best;
        }
        return res;


    }

    public static void generate(String s,List<String> list) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i ; j < s.length() ; j++){
                sb.append(s.charAt(j));
                list.add(sb.toString());
            }
        }
    }
    public static int manualCompareTo(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int n = Math.min(n1,n2);

        for(int i = 0 ; i < n ; i++){
            int c1 = s1.charAt(i);
            int c2 = s2.charAt(i);

            if(c1 != c2)return c1 - c2;
        }
        return n1 - n2;//smaller string is the lg lly smallest if all characters are same
    }
}
