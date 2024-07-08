package LeetCodeContests.Weekly405;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeroes {
    public static void main(String[] args) {
        int n = 18;
        System.out.println(validStrings(n));
    }

    public static List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        memo(n,0,-1,list,new StringBuilder());
        return list;
    }

    public static void memo(int n , int i , int prev,List<String> list,StringBuilder sb){
        if(i == n){
            list.add(sb.toString());
            return;
        }

        if(prev == -1 || prev == 1){
            sb.append("0");
            memo(n,i + 1,0,list,sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("1");
            memo(n,i + 1,1,list,sb);
            sb.deleteCharAt(sb.length() - 1);
        }else {
            sb.append("1");
            memo(n,i + 1,1,list,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
