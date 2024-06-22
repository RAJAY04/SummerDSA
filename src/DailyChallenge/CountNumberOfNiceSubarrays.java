package DailyChallenge;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums,k));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        return function(nums,k) - function(nums,k - 1);
    }
    public static int function(int[] nums,int goal){//this qn is same as LC 930
        int i = 0 , j = 0 ;
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        while(j < n){
            sum += nums[j] % 2 == 0 ? 0 : 1;
            while(i <= j && sum > goal){
                sum -= nums[i] % 2 == 0 ? 0 : 1;
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
    public static int prefixSum(int[] nums,int k){
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int sum = 0;
        int ans = 0;
        prefix[0] = 1;
        for(int i = 0 ; i < n; i++){
            sum += nums[i] % 2 == 0 ? 0 : 1;
            if(sum - k >= 0){
                ans += prefix[sum - k];
            }
            prefix[sum]++;
        }
        return ans;
    }
}
