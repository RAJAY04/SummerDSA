package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {
    public static void main(String[] args) {
        System.out.println(partition("efe"));
    }
    static List<List<String>> res;
    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(s,temp);
        return res;
    }

    public static void helper(String s, List<String> temp){
        if(s.isEmpty()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < s.length(); i++){
            if(isPalindrome(s.substring(0,i + 1))){
                temp.add(s.substring(0,i + 1));
            }else{
                continue;
            }

            helper(s.substring(i + 1,s.length()),temp);
            temp.remove(temp.size() -1);
        }
    }
    public static boolean isPalindrome(String s){
        if(s.length() == 1)return true;
        int i = 0 , j = s.length() -1;
        while( i <= j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
