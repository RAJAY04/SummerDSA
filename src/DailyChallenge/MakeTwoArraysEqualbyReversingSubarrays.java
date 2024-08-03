package DailyChallenge;

import java.util.Arrays;

public class MakeTwoArraysEqualbyReversingSubarrays {
    public static void main(String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(canBeEqual(target,arr));
    }
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        return Arrays.equals(target,arr);
    }
}
