package Greedy;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(**(*()**()**((**(*)";
        System.out.println(checkValidString(s));
    }
    //resolve this quesiton , all test cases didint pass
    public static boolean checkValidString(String s) {
        int leftCount = 0 , rightCount = 0 , starCount = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                leftCount++;
            }else if(c == '*'){
                starCount++;
            }else if (c == ')'){
                rightCount++;
                if(rightCount > leftCount && starCount > 0){
                    starCount--;
                    leftCount++;
                }else if(rightCount > leftCount && starCount == 0){
                    return false;
                }
            }
        }
        if(leftCount > rightCount && starCount + rightCount >= leftCount)return true;
        if(leftCount != rightCount)return false;
        else return true;
    }
    //given below is gpts ans, 2 pass would have worked :)

    public boolean checkValidString1(String s) {
        int leftCount = 0, rightCount = 0, starCount = 0;

        // Forward pass: balance open and close parentheses considering '*' as '(' or empty string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else if (c == '*') {
                starCount++;
            } else if (c == ')') {
                rightCount++;
                if (rightCount > leftCount + starCount) {
                    return false;
                }
            }
        }

        // If there are more open parentheses than can be balanced with stars and close parentheses
        if (leftCount > rightCount + starCount) {
            return false;
        }

        leftCount = 0;
        rightCount = 0;
        starCount = 0;

        // Backward pass: balance close and open parentheses considering '*' as ')' or empty string
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                rightCount++;
            } else if (c == '*') {
                starCount++;
            } else if (c == '(') {
                leftCount++;
                if (leftCount > rightCount + starCount) {
                    return false;
                }
            }
        }

        return true;
    }
}
