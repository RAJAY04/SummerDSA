package dp.dpOnSubsequence;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PartitionWithGivenDifference {
    //this code is copied from strivers sheet as i know how its done, resolv some other day
    static int mod =(int)(Math.pow(10,9)+7);
    static int countPartitionsUtil(int ind, int target,int[] arr, int[][] dp){

        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = countPartitionsUtil(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = countPartitionsUtil(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= (notTaken + taken)%mod;
    }

    static int countPartitions(int d,int[] arr){
        int n = arr.length;
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;

        int s2 = (totSum-d)/2;

        int dp[][] = new int[n][s2+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        return countPartitionsUtil(n-1,s2,arr,dp);
    }
    static int findWays(int[] num, int tar){
        int n = num.length;

        int dp[][] = new int[n][tar+1];

        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][tar];
    }

    static int countPartitions1(int n, int d,int[] arr){
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d <0 || (totSum-d)%2==1 ) return 0;

        return findWays(arr,(totSum-d)/2);
    }

    static int findWays1(int[] num, int tar){
        int n = num.length;

        int prev[] = new int[tar+1];

        if(num[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
        else prev[0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            int cur[]=new int[tar+1];
            for(int target= 0; target<=tar; target++){
                int notTaken = prev[target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];

                cur[target]= (notTaken + taken)%mod;
            }
            prev = cur;
        }
        return prev[tar];
    }

    static int countPartitions(int n, int d,int[] arr){
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d <0 || (totSum-d)%2 ==1) return 0;

        return findWays(arr,(totSum-d)/2);
    }


    public static void main(String args[]) {

        int arr[] = {5,2,6,4};
        int d=3;

        System.out.println("The number of subsets found are "+countPartitions(d,arr));
    }
}
