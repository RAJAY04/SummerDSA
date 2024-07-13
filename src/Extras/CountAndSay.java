package Extras;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(countAndSay(n));
    }
    public static String countAndSay(int n) {
        String ans = "1";
        for(int i = 2 ; i <= n ; i++){
            String temp = ans;
            ans = encode(temp);
        }
        return ans;
    }
    public static String encode(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0 ; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                count++;
            }else{
                sb.append(count + ""+ s.charAt(i));
                count = 1;
            }
        }
        if(count > 1)sb.append(count + "" + s.charAt(s.length() -1));
        else sb.append(1 + "" + s.charAt(s.length() - 1));
        return sb.toString();
    }
}
