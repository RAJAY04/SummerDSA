package LeetCodeContests.Biweekly133;

public class MinOpToMakeBinaryarrEleTO2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1,1,1,1};
        System.out.println(minOperations(arr));
    }
    public static int minOperations(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                if(count % 2 == 0){
                    count++;
                }
            }else{
                if(count % 2 == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
