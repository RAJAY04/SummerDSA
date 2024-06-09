package LeetCodeContests.Biweekly132;

public class ClearDigits {
    public static void main(String[] args) {
          String s = "";
        System.out.println(clearDigits(s));
    }
    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < sb.length(); i++){
            if(Character.isDigit(sb.charAt(i))){
                boolean flag = mark(sb,i - 1);
                if(flag){
                    sb.setCharAt(i,'*');
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0  ; i < sb.length() ;i++){
            if(sb.charAt(i) != '*')ans.append(sb.charAt(i));
        }
        return ans.toString();
    }

    public static boolean mark(StringBuilder sb, int i){
        boolean flag = false;
        for(int j = i ; j >= 0; j--){
            if(!Character.isDigit(sb.charAt(j)) && sb.charAt(j) != '*'){
                sb.setCharAt(j,'*');
                flag = true;
                break;
            }
        }
        return flag;
    }
}
