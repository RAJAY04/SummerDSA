package DailyChallenge;

import java.util.HashSet;
import java.util.Set;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        int c = 2147483600;
        System.out.println(judgeSquareSum(c));

    }
    public static boolean judgeSquareSum1(int c) {//gives TLE
        Set<Integer> set = new HashSet<>();
        for(int a = 0 ; a * a <= c ;a++){
            set.add(a * a);
        }

        for(int b = 0 ; b * b <= c; b++){
            int target = c - (b * b);
            if(set.contains(target)){
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum(int c) {
        int left = 0 , right = (int)Math.sqrt(c);
        while(left <= right){
            long total = (long)left * left + (long)right * right;
            if(total == c)return true;
            else if(total < c){
                left++;
            }else right--;
        }
        return false;
    }
}
