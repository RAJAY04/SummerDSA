package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
    static List<String> ans;
    public static List<String> letterCombinations(String digits) {
        String[] mapper = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ans = new ArrayList<>();
        helper(digits,new StringBuilder(),0,mapper);
        return ans;
    }
    public static void helper(String digits,StringBuilder sb, int index,String[] mapper){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        for(int i = 0 ; i < mapper[digits.charAt(index) - '0'].length() ;i++){
            sb.append(mapper[digits.charAt(index) - '0'].charAt(i));
            helper(digits,sb,index + 1,mapper);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
