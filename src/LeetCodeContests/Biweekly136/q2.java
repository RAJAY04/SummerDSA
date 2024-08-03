package LeetCodeContests.Biweekly136;

import java.util.HashMap;
import java.util.Map;

public class q2 {
    public static void main(String[] args) {

    }

    public static int minFlips(int[][] pick) {
        int n = pick.length, m = pick[0].length;
        int res1 = 0;
        for(int[] arr : pick){
            res1 += operations(arr);
        }

        int res2 = 0;
        for (int col = 0; col < m; col++) {
            int[] colArray = new int[n];
            for (int row = 0; row < n; row++) {
                colArray[row] = pick[row][col];
            }
            res2 += operations(colArray);
        }

        return Math.min(res1,res2);

    }

    public static int operations(int[] nums){
        int cnt = 0;
        for(int i = 0 ; i < nums.length / 2; i++){
            if(nums[i] == nums[nums.length - i - 1])cnt++;
        }
        return cnt;
    }
}
