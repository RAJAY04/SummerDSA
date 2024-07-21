package LeetCodeContests.Weekly407;

public class MaximumNumberofOperationstoMoveOnestotheEnd {
    public static void main(String[] args) {
        String s = "1001101";
        System.out.println(maxOperations(s));
    }
    public int maxOperations1(String s) {
        int count = 0 , ones = 0;
        for(int i = 0 ; i < s.length() - 1; i++){
            if(s.charAt(i) == '1')ones++;
            if(s.charAt(i) == '1' && s.charAt(i + 1) == '0'){
                count += ones;
            }
        }
        return count;
    }
    public static int maxOperations(String s) {
        int addFactor = 0;
        int n = s.length();
        int i = n - 1;
        while(i >= 0 && s.charAt(i) == '1'){
            i--;
        }

        int res = 0;
        for(int j = i; j >= 0; j--){
            if(s.charAt(j) == '1'){
                if(j > 0){
                    if(s.charAt(j - 1) == '0'){
                        res++;
                        res += addFactor;
                        addFactor++;
                    }else{
                        res++;
                        res += addFactor;
                    }
                }else{
                    res++;
                    res += addFactor;
                }
            }
        }
        return res;
    }
}
