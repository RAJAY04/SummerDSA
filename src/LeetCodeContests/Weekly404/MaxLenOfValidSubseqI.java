package LeetCodeContests.Weekly404;

public class MaxLenOfValidSubseqI {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,2,1,2};
        System.out.println(new MaxLenOfValidSubseqI().maximumLength(nums));
        System.out.println(maximumLength1(nums));
    }
    public int maximumLength(int[] nums) {
        //aryans code confustion to understand
        int n = nums.length;
        int[][] dp = new int[2][2];
        int ans = 0;
        for(int i = 0 ; i < n ;i++){
            int curRem = nums[i] % 2;
            dp[curRem][0] = Math.max(dp[curRem][0],1 + dp[0][curRem]);
            dp[curRem][1] = Math.max(dp[curRem][1],1 + dp[1][curRem]);
            ans = Math.max(ans,Math.max(dp[curRem][0],dp[curRem][1]));
        }
        return ans;
    }

    public static int maximumLength1(int[] nums) {
        int countOdd = 0 , countEven = 0 , countAlternate = 0;
        byte takeOdd = -1;//this is a really smart move, this avoids us to consider (odd,even) and (even,odd) case seperately
        for(int num : nums){
            if(num % 2 == 0){
                countEven++;
                if(takeOdd != 1){
                    countAlternate++;
                    takeOdd = 1;
                }
            }else{
                countOdd++;
                if(takeOdd != 0){
                    countAlternate++;
                    takeOdd = 0;
                }
            }
        }
        return Math.max(countAlternate,Math.max(countEven,countOdd));
    }
}
