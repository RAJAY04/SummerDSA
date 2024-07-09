package LCVirtualContests.Weekly397;

import java.util.ArrayList;
import java.util.Arrays;

public class TakingMaxEnergyFromMysticDungeon {
    public static void main(String[] args) {
        int[] energy = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(maximumEnergy1(energy,k));
    }
    public static int maximumEnergy1(int[] energy, int k) {
        //just if we write a n^2 solution it wont work
        // the point to note here is that if we start from any index we will end up fron n - 1 to n - 1 - kth index for sure
        // so we can start from n - 1 to n - 1 - kth index and keep on adding the energy and keep on updating the max energy
        // we can do this in O(n) time approx
        int ans = Integer.MIN_VALUE, sum = 0;
        int n = energy.length;
        for(int i = n - 1; i > n - k - 1 ;i--){//complexity is O(k)
            sum = 0;
            for(int j = i; j >= 0; j -= k){//complexity is O(n/k)
                sum += energy[j];
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }
    public int maximumEnergy2(int[] energy, int k) {
        int n=energy.length;
        int maxi=Integer.MIN_VALUE;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,solve(energy,k,i,dp));
        }
        return maxi;
    }
    private int solve(int[] energy,int k,int indx,int[] dp){
        if(indx>=energy.length)
            return 0;
        if(dp[indx]!=-1)
            return dp[indx];
        int take=energy[indx]+solve(energy,k,indx+k,dp);
        return dp[indx]=take;
    }

}
