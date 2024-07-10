package LCVirtualContests.Weekly396;

public class MinLenOfAnagramConcat {
    public static void main(String[] args) {
        String s = "abbaabbaabba";
        System.out.println(minAnagramLength(s));
    }
    public static int minAnagramLength(String s) {
        int n = s.length();
        for(int len = 1; len <= n/2 ; len++){
            if(n % len == 0 && check(s,len))return len;
        }
        return n;
    }
    public static boolean check(String s, int len ){
        int[] firstFreq = new int[26];
        int n = s.length();
        for(int i = 0 ; i < len ; i++)firstFreq[s.charAt(i) - 'a']++;
        for(int i = len ; i < n ; i += len){
            int[] rangeFreq = new int[26];
            for(int j = i ; j < i + len ; j++){
                rangeFreq[s.charAt(j) - 'a']++;
            }
            for(int j = 0 ; j < 26; j++){
                if(firstFreq[j] != rangeFreq[j])return false;
            }
        }
        return true;
    }
}
