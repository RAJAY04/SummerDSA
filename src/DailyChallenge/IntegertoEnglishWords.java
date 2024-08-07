package DailyChallenge;

import java.util.Stack;

public class IntegertoEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(1000));
    }
    static String[] units = {
            "",        // 0
            "One",     // 1
            "Two",     // 2
            "Three",   // 3
            "Four",    // 4
            "Five",    // 5
            "Six",     // 6
            "Seven",   // 7
            "Eight",   // 8
            "Nine",    // 9
            "Ten",     // 10
            "Eleven",  // 11
            "Twelve",  // 12
            "Thirteen",// 13
            "Fourteen",// 14
            "Fifteen", // 15
            "Sixteen", // 16
            "Seventeen",//17
            "Eighteen",// 18
            "Nineteen" // 19
    };
    static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] hundreds = {"", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred",
            "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};
    static String[] suffix = {"", "Thousand", "Million", "Billion"};
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";


        Stack<String> st = new Stack<>();
        int suffixCntr = 0;
        while (num != 0) {
            int chunk = num % 1000;
            if (chunk != 0) {
                String str = helper(chunk);
                st.add(suffix[suffixCntr]);
                st.add(str);
            }
            num /= 1000;
            suffixCntr++;
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
            if (!st.isEmpty() && !st.peek().isEmpty()) {
                res.append(" ");
            }
        }
        return res.toString().trim();
    }

    public static String helper(int num){
        int[] digits = new int[3];
        int i = 2;
        while(num != 0){
            digits[i--] = num % 10;
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        if (digits[0] > 0) {
            sb.append(hundreds[digits[0]]).append(" ");
        }
        if (digits[1] == 1) {
            sb.append(units[10 + digits[2]]);
        } else {
            if (digits[1] > 1) {
                sb.append(tens[digits[1]]).append(" ");
            }
            if (digits[2] > 0) {
                sb.append(units[digits[2]]);
            }
        }

        return sb.toString().trim();
    }

}
