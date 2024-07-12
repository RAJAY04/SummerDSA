package LCVirtualContests.Biweekly129;

import java.util.Arrays;

public class FindAllPossibleStableBinaryArraysI {
    public static void main(String[] args) {
        int zero = 3 , one = 3, limit = 2;
        System.out.println(numberOfStableArrays(zero,one,limit));
    }
    public static int numberOfStableArrays(int zero, int one, int limit) {
        int[][][][] dp = new int[zero + 1][one + 1][limit + 1][2];
        for(int[][][] arr : dp){
            for(int[][] ar : arr){
                for(int[] a : ar)
                    Arrays.fill(a,-1);
            }
        }
        return memo(zero,one,limit,limit,-1,dp);
    }
    public static int memo(int zero,int one,int curLimit ,int limit,int prev,int[][][][] dp){
        if(one < 0 || zero < 0)return 0;
        if(zero == 0 && one == 0)return 1;

        if(prev != -1 && dp[zero][one][curLimit][prev] != -1){
            return dp[zero][one][curLimit][prev];
        }

        int ans = 0;

        if(curLimit == 0){
            if(prev == 0){
                ans += memo(zero,one - 1,limit - 1,limit,1,dp);
            }else if(prev == 1){
                ans += memo(zero - 1,one,limit - 1,limit,0,dp);
            }
        }else{
            if(prev == 0){
                ans += memo(zero - 1,one,curLimit - 1,limit,0,dp);
                ans += memo(zero ,one - 1,limit - 1,limit,1,dp);
            }else if(prev == 1){
                ans += memo(zero,one - 1,curLimit - 1,limit,1,dp);
                ans += memo(zero - 1,one ,limit - 1,limit,0,dp);
            }else{
                ans += memo(zero - 1, one,curLimit - 1,limit,0,dp);
                ans += memo(zero,one - 1,curLimit - 1, limit,1,dp);

            }
        }
        if(prev != -1)return dp[zero][one][curLimit][prev] = ans;
        else return ans;
    }

}
