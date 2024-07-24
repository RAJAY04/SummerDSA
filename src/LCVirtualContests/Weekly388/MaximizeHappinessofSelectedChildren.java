package LCVirtualContests.Weekly388;

import java.util.Arrays;

public class MaximizeHappinessofSelectedChildren {
    public static void main(String[] args) {
        int[] happiness = {1,2,3,4,5};
        int k = 1;
        System.out.println(maximumHappinessSum(happiness,k));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long res = 0;
        int sub = 0;
        Arrays.sort(happiness);

        int j = n - 1;

        while(k-- > 0){
            res += Math.max(0,happiness[j--] - sub++);
        }
        return res;
    }
}
