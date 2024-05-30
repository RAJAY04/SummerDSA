package BitManipulation;

public class SingleNumberII {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,5,5,5,4,4,4,3};
        System.out.println(solve(arr));
        System.out.println(solveHard(arr));
    }

    private static int solve(int[] arr) {
        int count = 0;
        int ans = 0;
        for(int i = 0 ; i < 32; i++){
            count = 0;
            for(int num : arr){
                if((num & (1 << i)) != 0){
                    count += 1;
                }
            }
            if(count % 3 == 1){
                ans = ans | 1 << i;
            }
        }
        return ans;
    }

    public static int solveHard(int[] arr){
        int ones = 0 , twos = 0;
        for(int num : arr){
            //concept of buckets
            ones = (ones ^ num)&(~twos);
            twos = (twos ^ num)&(~ones);
        }
        return ones;
    }
}
