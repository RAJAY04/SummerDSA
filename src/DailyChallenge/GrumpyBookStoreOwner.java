package DailyChallenge;

import java.util.HashSet;
import java.util.Set;

public class GrumpyBookStoreOwner {
    public static void main(String[] args) {
        int[] customers = {1};
        int[] grumpy = {1};
        int minutes = 8;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int n = customers.length;
        for(int i = 0 ; i < n; i++){
            if(grumpy[i] == 0)ans += customers[i];
        }

        int i = 0 , j = 0;
        int windowSum = 0;
        int max = 0;
        while(j < n){
            if(j - i + 1 <= minutes){
                if(grumpy[j] == 1){
                    windowSum += customers[j];
                }j++;
            }else{
                if(grumpy[i] == 1)windowSum -= customers[i];
                i++;
            }
            max = Math.max(windowSum,max);
        }
        return ans + max;

    }
}
