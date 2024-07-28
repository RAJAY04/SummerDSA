package LeetCodeContests.Weekly408;

import java.util.Arrays;

public class FindtheCountofNumbersWhichAreNotSpecial {
    public static void main(String[] args) {
        int l = 4 , r = 16;
        System.out.println(nonSpecialCount(l,r));
    }

    public static int nonSpecialCount(int l, int r) {
        int n = (int) Math.sqrt(r);
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int total = r - l + 1;
        int primeSquares = 0;
        for(int i = 2 ; i < isPrime.length; i++){
            if(isPrime[i]){
                if(i * i > r){
                    break;
                }else if(i * i < l)continue;
                else primeSquares++;
            }
        }
    return total - primeSquares;
    }
}
