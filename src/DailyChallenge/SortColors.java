package DailyChallenge;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
    public static void sortColors(int[] nums) {
        if(nums.length == 1)return;
        int low = 0 , mid = 0 , high = nums.length - 1;
        while(mid <= high){// <= else [2,0,1] will fail
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums,mid,high);
                high--;//we dont move mid because, high may have had a 0,and we just cant put 0 in the center. so dont move mid
                //dry run 0,1,2,1,0,2 example to understand
            }else mid++;
        }
    }
    public static void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
