package Greedy;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
        System.out.println(candy1(ratings));
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies,1);

        for(int i = 1; i < n ; i++){
            if(ratings[i] > ratings[ i - 1]){
                candies[i] = candies[ i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i],candies[i + 1] + 1);
            }
        }
        int ans = 0;

        ans = Arrays.stream(candies).sum();
        return ans;
    }

    //code this yourself again
    public static int candy1(int[] ratings) {
        int n = ratings.length;
        int totalCandies = n;
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int currentPeak = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                currentPeak++;
                totalCandies += currentPeak;
                i++;
            }

            if (i == n) {
                return totalCandies;
            }

            int currentValley = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                currentValley++;
                totalCandies += currentValley;
                i++;
            }

            totalCandies -= Math.min(currentPeak, currentValley);
        }

        return totalCandies;
    }
}
