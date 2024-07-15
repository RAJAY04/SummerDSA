package LCVirtualContests.Weekly393;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestAmountWithSingleDenominationCombination {
    public static void main(String[] args) {
        int[] coins = {3,4,5,7,11};
        int k = 10;
        System.out.println(findKthSmallest(coins, k));
    }

    public static long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < coins.length - 1; i++){
            if(coins[i] == -1)continue;
            for(int j = i + 1 ; j < coins.length; j++){
                if(coins[j] % coins[i] == 0 && coins[j] != -1){
                    coins[j] = -1;//mark all multiples of smallest number as -1
                }
            }
        }
        for(int i = 0 ; i < coins.length ; i++){
            if(coins[i] != -1)list.add(coins[i]);//add all numbers after removing those multiples
        }

        if(list.get(0) == 1)return (long)k;
        int num = list.get(0);//smallest num as we sort
        long subtractionFactor = 0;//total number of common multiples of other numbers except the smallest
        long ans = num * k;//min ans if other numbers dont have common
        for(int i = 1 ; i < list.size(); i++){
            int n = list.get(i);
            long count = ans / n;// gives total number of multiples btw n & ans
            subtractionFactor += (count / num);//gives common multiples
        }
        return ans - ( subtractionFactor * num);
    }
}
