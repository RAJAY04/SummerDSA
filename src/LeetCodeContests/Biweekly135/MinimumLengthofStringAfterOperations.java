package LeetCodeContests.Biweekly135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumLengthofStringAfterOperations {
    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < 26; i++){
            map.put((char)('a' + i) , 0);
        }
        int res = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            map.put(c,map.getOrDefault(c,0)+ 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            int len  = entry.getValue();
            if(len < 3)continue;
            int count = 0;
            if(len % 2 == 0)count--;
            count += len / 2;
            res += count * 2;
        }

        return s.length() - res;
    }
}
