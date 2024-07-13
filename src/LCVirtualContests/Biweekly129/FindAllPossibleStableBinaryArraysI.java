package LCVirtualContests.Biweekly129;

import java.util.Arrays;

public class FindAllPossibleStableBinaryArraysI {
    public static void main(String[] args) {
        int zero = 3 , one = 3, limit = 2;
        System.out.println(numberOfStableArrays(zero,one,limit));
        System.out.println(numberOfStableArrays1(zero,one,limit));
        System.out.println(tabutaion(zero,one,limit));
        System.out.println(aryansTabulation(zero,one,limit));
        System.out.println(aryansOptimised(zero,one,limit));
    }
    static int mod = 1000000007;
    public static int numberOfStableArrays(int zero, int one, int limit) {
        int[][][][] dp = new int[zero + 1][one + 1][limit + 1][2];
        for (int[][][] arr : dp) {
            for (int[][] ar : arr) {
                for (int[] a : ar)
                    Arrays.fill(a, -1);
            }
        }
        return memo(zero, one, limit, limit, -1, dp) % mod;
    }

    public static int memo(int zero, int one, int curLimit, int limit, int prev, int[][][][] dp) {
        if (one < 0 || zero < 0) return 0;
        if (zero == 0 && one == 0) return 1;

        if (prev != -1 && dp[zero][one][curLimit][prev] != -1) {
            return dp[zero][one][curLimit][prev];
        }

        int ans = 0;

        if (curLimit == 0) {
            if (prev == 0) {
                ans += memo(zero, one - 1, limit - 1, limit, 1, dp);
            } else if (prev == 1) {
                ans += memo(zero - 1, one, limit - 1, limit, 0, dp);
            }
        } else {
            if (prev == 0) {
                ans += memo(zero - 1, one, curLimit - 1, limit, 0, dp) % mod;
                ans += memo(zero, one - 1, limit - 1, limit, 1, dp) % mod;
            } else if (prev == 1) {
                ans += memo(zero, one - 1, curLimit - 1, limit, 1, dp) % mod;
                ans += memo(zero - 1, one, limit - 1, limit, 0, dp) % mod;
            } else {
                ans += memo(zero - 1, one, curLimit - 1, limit, 0, dp) % mod;
                ans += memo(zero, one - 1, curLimit - 1, limit, 1, dp) % mod;
            }
        }

        if (prev != -1) {
            dp[zero][one][curLimit][prev] = ans;
        }

        return ans;
    }


    public static int numberOfStableArrays1(int zero, int one, int limit) {
        int[][][] dp = new int[zero + 1][one + 1][2];
        for (int[][] arr : dp) {
            for (int[] ar : arr) {
                Arrays.fill(ar, -1);
            }
        }
        // Start with no previous element (-1)
        return (memo1(zero, one, limit, -1, dp) % mod);
    }

    public static int memo1(int zero, int one, int limit, int prev, int[][][] dp) {
        if (one < 0 || zero < 0) return 0;
        if (zero == 0 && one == 0) return 1;

        if (prev != -1 && dp[zero][one][prev] != -1) {
            return dp[zero][one][prev];
        }

        long ans = 0;

        // Place zeros if the previous element was not zero
        if (prev != 0) {
            for (int i = 1; i <= Math.min(zero, limit); i++) {
                ans = (ans + memo1(zero - i, one, limit, 0, dp)) % mod;
            }
        }

        // Place ones if the previous element was not one
        if (prev != 1) {
            for (int i = 1; i <= Math.min(one, limit); i++) {
                ans = (ans + memo1(zero, one - i, limit, 1, dp)) % mod;
            }
        }

        if (prev != -1) {
            dp[zero][one][prev] = (int)ans;
        }

        return (int)ans;
    }

    public static int tabutaion(int zero, int one, int limit){
        int[][][] dp = new int[zero + 1][one + 1][2];
        dp[0][0][0] = 1;//if we have 0 zeros and 0 ones and the previous element was 0
        dp[0][0][1] = 1;//if we have 0 zeros and 0 ones and the previous element was 1
        for(int i = 0 ; i <= zero; i++){
            for(int j = 0 ; j <= one; j++){
                for(int k = 0 ; k < 2; k++){//k = 0 means the previous element was 0 and k = 1 means the previous element was 1
                    if(k == 0){
                        for(int l = 1; l <= Math.min(limit,i); l++){
                            dp[i][j][k] = (dp[i][j][k] + dp[i - l][j][1]) % mod;//dp[i - l][j][1] can only add this part when prev no was 1; so k = 1
                        }
                    }else{
                        for(int l = 1; l <= Math.min(limit,j); l++){
                            dp[i][j][k] = (dp[i][j][k] + dp[i][j - l][0]) % mod;//dp[i][j - l][0] can only add this part when prev no was 0; so k = 0
                        }
                    }
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }

    public static int aryansTabulation(int zero,int one ,int limit){
        int[][][] dp = new int[zero + 1][one + 1][2];

        for(int z = 0 ; z <= zero ;z++)dp[z][0][0] = 1;
        for(int o = 0 ; o <= one ;o++)dp[0][o][1] = 1;

        for(int z = 1 ; z <= zero; z++){//i cant start from 1 now, as my base case is ready
            for(int o = 1 ; o <= one; o++){
                for(int cnt = 1 ; cnt <= Math.min(z,limit); cnt++){
                        dp[z][o][0] = (dp[z][o][0] + dp[z - cnt][o][1]) % mod;
                }
                for(int cnt = 1 ; cnt <= Math.min(o,limit); cnt++){
                    dp[z][o][1] = (dp[z][o][1] + dp[z][o - cnt][0]) % mod;
                }
            }

        }
        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }

    public static int aryansOptimised(int zero,int one ,int limit){
        int[][][] dp = new int[zero + 1][one + 1][2];

        // Base case initialization
        for (int z = 0; z <= Math.min(zero,limit); z++) dp[z][0][0] = 1;
        for (int o = 0; o <= Math.min(one,limit); o++) dp[0][o][1] = 1;

        for (int z = 1; z <= zero; z++) {
            for (int o = 1; o <= one; o++) {
                dp[z][o][0] = (dp[z - 1][o][0] + dp[z - 1][o][1]) % mod;
                dp[z][o][1] = (dp[z][o - 1][0] + dp[z][o - 1][1]) % mod;
                //this is the only part that is different from the above tabulation
                //we are mimicing the for loop of the above tabulation
                if (z > limit) {
                    dp[z][o][0] = (dp[z][o][0] - dp[z - limit - 1][o][1] + mod) % mod;
                }
                if (o > limit) {
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o - limit - 1][0] + mod) % mod;
                }
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}
