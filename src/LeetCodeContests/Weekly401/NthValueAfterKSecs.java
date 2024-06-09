package LeetCodeContests.Weekly401;

public class NthValueAfterKSecs {
    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        System.out.println(valueAfterKSeconds(n,k));
    }
    static int mod = 1000000007;
    public static int valueAfterKSeconds(int n, int k) {
        if(k == 1)return n;
        if(n == 1)return 1;
        long[] arr = new long[n + 1];
        for(int i = 1 ; i <= n ; i++){
            arr[i] = i;
        }
        for(int i = 1 ; i < k ; i++){
            for(int j = 2; j <= n; j++){
                arr[j] = (arr[j - 1] + arr[j])%mod;
            }
        }
        return (int)(arr[n] % mod);
    }
}
