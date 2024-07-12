package DailyChallenge;

import java.util.Arrays;
import java.util.Stack;

public class RevSubStrBtwEachPairOfParenthesis {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }
    public static String reverseParentheses1(String s) {
        Stack<Character> st = new Stack<>();

        for( char c : s.toCharArray()){
            if(c == ')'){
                StringBuilder temp = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '(')temp.append(st.pop());
                if(!st.isEmpty())st.pop();
                for(int i = 0 ; i < temp.length(); i++)st.push(temp.charAt(i));
            }else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())sb.append(st.pop());
        return sb.reverse().toString();
    }
    public static String reverseParentheses(String s) {
        //wormhole teleportation
        //gather all open parenthesis and when we find a closing pop recent open parenthesis and mark them as in code.
        Stack<Integer> openParenthesis = new Stack<>();
        int n = s.length();
        int[] indexes = new int[n];
        for(int i = 0 ; i < n; i++){
            if(s.charAt(i) == '('){
                openParenthesis.push(i);
            }else if(s.charAt(i) == ')'){
                int opening = openParenthesis.pop();
                int closing = i;
                indexes[opening] = closing;
                indexes[closing] = opening;
            }
        }
        StringBuilder res = new StringBuilder();
        int d = 1;
        for(int i = 0 ; i < n ; i += d){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = indexes[i];
                d *= -1;
            }else res.append(s.charAt(i));
        }
        return res.toString();
    }
}
