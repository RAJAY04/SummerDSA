package LeetCodeContests.Weekly404;

public class FindtheMaximumLengthofValidSubsequenceII {
    public static void main(String[] args) {
        int[] nums = {1,4,2,3,1,4};
        int k = 3;
        System.out.println(maximumLength(nums,k));
    }
//dp[cur][mod] represents the length of the longest valid subsequence that ends with a number that has a remainder cur when divided by k,
// and the sum of the current number and the previous number in the subsequence leaves a remainder mod when divided by k

    public static int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int max = 1;
        for(int num : nums){
            int cur = num % k;
            for(int mod = 0 ; mod < k ; mod++){
                int prev = (mod - cur + k) % k;// wkt (cur + prev) % k = mod
                dp[cur][mod] = 1 + dp[prev][mod];//no need to take max as all dp is initialised with 0
                max = Math.max(max,dp[cur][mod]);
            }
        }return max;
    }
    //Let A be subsequence , with some mod
    //say mod = (A[i] + A[i+1]) % k = (A[i + 1] + A[i + 2]) % k = ...
    //DP[currNum][mod] denotes the maximum length of the mod subsequence (subsequence having this mod) ending with currNum
    //Say we at index i , currNum = nums[i]
    //This currNum can be a part of any of subsequence having mod = [0 , k-1]
    //So , we'll try to make our currNum to be a part of all possible subsequenes and choose the maximum out of it
    //For currNum to be a part of mod subsequence
    //=> (currNum + prevNum) % k = mod
    //=> prevNum = (mod - currNum + k) % k
    //DP[currNum][mod] = max(DP[currNum][mod] , 1 + DP[prevNum][mod])
    //Complexity:
    //Time Complexity : O(N * K)
    //Space Complexity : O(K * K)
}
