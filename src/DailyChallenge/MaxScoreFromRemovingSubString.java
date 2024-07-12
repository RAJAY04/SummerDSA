package DailyChallenge;

import java.util.Stack;

public class MaxScoreFromRemovingSubString {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println(maximumGain(s,x,y));
    }
    public static int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        boolean removeABFirst = x >= y;
        int points = 0;

        // First pass: remove the pair that gives more points
        if (removeABFirst) {
            // Remove "ab" pairs first if they give more points
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                    points += x;
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        } else {
            // Remove "ba" pairs first if they give more points
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                    points += y;
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        // Prepare the remaining string from the stack
        StringBuilder remainingString = new StringBuilder();
        while (!stack.isEmpty()) remainingString.append(stack.pop());
        s = remainingString.toString();
        stack.clear();

        // Second pass: remove the remaining pair from the reversed string
        if (removeABFirst) {
            // Remove "ba" pairs in the reversed string
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                    points += y;//ensure that we add y now cz actually we are removing ba
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        } else {
            // Remove "ab" pairs in the reversed string
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                    points += x;//actually we are removing ab so add x
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return points;
    }

    //the most optimal solution is using two pointers and replicate the above process , construct the string for 2nd iteration simultaneously

}
