package DailyChallenge;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression {
    public static void main(String[] args) {
        String expression = "!(&(!(&(f)),&(t),|(f,f,t)))";
        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Character> expressionStack = new Stack<>();
        for(int i = 0 ; i < expression.length() ;i++){
            char c = expression.charAt(i);
            if(isOperator(c)){
                operatorStack.push(c);
            }else if(c == ')'){
                char op = operatorStack.pop();
                List<Boolean> list = new ArrayList<>();
                while(!expressionStack.isEmpty() && expressionStack.peek() != '('){
                    char ch = expressionStack.pop();
                    if(ch == 'f'){
                        list.add(false);
                    }else list.add(true);
                }
                expressionStack.pop();
                expressionStack.push(operate(list,op));
            }else if(Character.isLetter(c) || c == '('){
                expressionStack.push(c);
            }
        }
        return expressionStack.pop() == 'f' ? false : true;

    }
    public static boolean isOperator(char ch) {
        return  ch == '&' || ch == '|' || ch == '!';
    }

    public static char operate(List<Boolean> list , char op){
        if(list.size() == 1){
            if(op != '!'){
                return (list.get(0) == false) ? 'f' : 't';
            }
            else{
                return (list.get(0) == false) ? 't' : 'f';
            }
        }
        Boolean ans = false;
        switch(op){
            case '&':
                for(Boolean b : list){
                    ans &= b;
                }
                break;
            case '|':
                for(Boolean b : list){
                    ans |= b;
                }
                break;
        }
        return ans == false ? 'f' : 't';
    }
}
