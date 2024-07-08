package LCVirtualContests.Weekly397;

import java.util.HashMap;
import java.util.Map;

public class PermuationDiffBtwTwoStrings {
    public static void main(String[] args) {
        String s = "abc";
        String t = "bac";
        System.out.println(findPermutationDifference(s,t));
    }
    public static int findPermutationDifference(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            map1.put(s.charAt(i),i);
        }
        for(int i = 0 ; i < t.length(); i++){
            map2.put(t.charAt(i),i);
        }

        int ans = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            int sIndex = map1.get(c);
            int tIndex = map2.get(c);
            ans += Math.abs(sIndex-tIndex);
        }
        return ans;
    }
}
