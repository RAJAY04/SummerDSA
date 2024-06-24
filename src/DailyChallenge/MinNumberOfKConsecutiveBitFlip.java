package DailyChallenge;

public class MinNumberOfKConsecutiveBitFlip {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;
//        System.out.println(minKBitFlips(nums,k));
        System.out.println(minKBitFlips1(nums,k));
        System.out.println(minKBitFlips2(nums,k));
    }
    public static int minKBitFlips(int[] nums, int k) {//gives tle
        int n = nums.length, flipCount = 0;
        for(int i = 0 ; i < n; i++){
            if(nums[i] == 1)continue;
            else{
                if(i + k <= n){
                    for(int j = i ; j < i + k ; j++){
                        nums[j] ^= 1;
                    }
                    flipCount++;
                }
            }
        }
        for(int num : nums)if(num == 0)return -1;
        return flipCount;
    }


    //its kind of like a sliding window approach where after kth index we check i -k index weather we flipped or not
    public static int minKBitFlips1(int[] nums, int k) {//gives tle
        int n = nums.length, flipCount = 0,curFlipCount = 0;
        byte[] flip = new byte[n];
        for(int i = 0 ; i < n; i++){
            if(i >= k){
                curFlipCount -= flip[i - k];
            }
            if((nums[i] == 0 && curFlipCount % 2 == 0) || (nums[i] == 1 && curFlipCount % 2 == 1)){
                if(i + k <= n){
                    flipCount++;
                    curFlipCount++;
                    flip[i] = 1;
                }else return -1;

            }

        }
        return flipCount;//O(N) O(N)
    }


    //here we are resusing given array and reverting it back after checking if flip in i - k, so that it remains un altered
    public static int minKBitFlips2(int[] nums, int k) {//gives tle
        int n = nums.length, flipCount = 0,curFlipCount = 0;
        for(int i = 0 ; i < n; i++){
            if(i >= k){
                if(nums[i - k] > 1){
                    curFlipCount -= 1;
                    nums[i - k] -= 2;
                }

            }
            if((nums[i] == 0 && curFlipCount % 2 == 0) || (nums[i] == 1 && curFlipCount % 2 == 1)){
                if(i + k <= n){
                    flipCount++;
                    curFlipCount++;
                    nums[i] += 2;
                }else return -1;//if it entered the first if condn means that there is a flip needed but we can flip now so -1;

            }
            if(nums[n - k] > 1)nums[n - k] -= 2;

        }
        return flipCount;
    }
}
