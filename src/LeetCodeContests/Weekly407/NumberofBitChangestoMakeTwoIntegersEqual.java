package LeetCodeContests.Weekly407;

public class NumberofBitChangestoMakeTwoIntegersEqual {
    public static void main(String[] args) {
        System.out.println(minChanges(13,4));
    }
    public int minChanges1(int n, int k) {
        k ^= n;
        int cnt = Integer.bitCount(k);
        k &= n;
        return cnt == Integer.bitCount(k) ? cnt : -1;
    }
    public static int minChanges(int n, int k) {
        if(n == k)return 0;
        if(n < k)return -1;

        String strN = Integer.toBinaryString(n);
        String strK = Integer.toBinaryString(k);

        int nLen = strN.length();
        int kLen = strK.length();

        int res = 0;
        int i = 0 , j = nLen - kLen;
        for(int ii = 0 ; ii < j; ii++){
            if(strN.charAt(ii) == '1')res++;
        }
        while(i < kLen && j <  nLen){
            if(strN.charAt(j)  == '1' && strK.charAt(i) == '0'){
                res++;
            }else if(strN.charAt(j) == '0' && strK.charAt(i) == '1')return -1;
            i++;
            j++;
        }

        return res;

    }
}
