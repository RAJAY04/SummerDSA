package LeetCodeContests.Biweekly134;

import java.util.Arrays;

public class MaxPointsAfterEnemyBattle {
    public static void main(String[] args) {
        int[] arr = {2,5};
        System.out.println(maximumPoints(arr,3));
    }
    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        if(currentEnergy == 0)return 0;
        Arrays.sort(enemyEnergies);
        int n = enemyEnergies.length;
        int largestPtr = n - 1;
        long points = 0;
        while((points >= 1 || currentEnergy >= enemyEnergies[0]) && largestPtr != -1){
            if(currentEnergy >= enemyEnergies[0]){
                points++;
                currentEnergy -= enemyEnergies[0];
            }else if(points >= 1){
                currentEnergy += enemyEnergies[largestPtr--];
            }
        }
        return points;
    }
}
