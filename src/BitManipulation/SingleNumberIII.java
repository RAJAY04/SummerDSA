package BitManipulation;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        int[] res = singleNumber(arr);
        System.out.println(res[0] + " " + res[1]);
    }
    //this is done using the concepts of bucket
    //we know that all numbers occur twice except for two numbers
    //so when we xor all the numbers we get xor of those two numbers as pairs cancel out
    //now we have to find the last set bit in the xor
    //using xor & (xor - 1) we remove the last set bit
    //now xor ^ xor & (xor - 1) means that we xor the number with the last set bit set and the number with the last set bit not set
    // this will give us last set bit number
    //now we can divide the numbers into two buckets based on the last set bit
    //and xor the numbers in the buckets to get the two numbers
    public static int[] singleNumber(int[] nums) {
        long xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        long lastSet = xor ^ (xor & (xor - 1));

        int b1 = 0 , b2 = 0;

        for(int i = 0 ; i < nums.length ;i++){
            if((lastSet & nums[i]) != 0){
                b1 ^= nums[i];
            }else b2 ^= nums[i];
        }

        return new int[]{b1,b2};

    }
}
