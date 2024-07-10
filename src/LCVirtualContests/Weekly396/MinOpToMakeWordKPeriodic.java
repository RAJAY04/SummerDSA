package LCVirtualContests.Weekly396;

import java.util.HashMap;
import java.util.Map;

public class MinOpToMakeWordKPeriodic {
    public static void main(String[] args) {
        String word = "leetcoleedee";
        int k = 2;
        System.out.println(minimumOperationsToMakeKPeriodic(word,k));
    }
    public static int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n; i += k){
            String str = word.substring(i,i + k);
            map.put(str,map.getOrDefault(str,0)+ 1);
        }

        int count = 0;
        for(int val : map.values()){
            count = Math.max(count,val);
        }

        int remaining = n - (count * k);
        return remaining / k;
    }
}
