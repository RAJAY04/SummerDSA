package LeetCodeContests.Biweekly133;

public class MinOpToMakeBinaryarrEleTO1 {
    public static void main(String[] args) {
        int[] arr = {0,0,0};
        System.out.println(minOperations(arr));
    }
    public static int minOperations(int[] nums) {
        int  j = 0, count = 0;
        int n = nums.length;
        while(j < n){
            while(j < n && nums[j] == 1)j++;
            if(j < n - 2){
                nums[j] ^= 1;
                nums[j + 1] ^= 1;
                nums[j + 2] ^= 1;
                count++;
                j++;
            }else break;
        }
        for(int i = 0; i < n ; i++){
            if(nums[i] != 1)return -1;
        }
        return count;
    }
}
