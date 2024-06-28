package DailyChallenge;

import java.util.Arrays;

public class MaxTotalImportanceOfRoads {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,0},{2,0},{3,0}};
        System.out.println(maximumImportance(n,roads));
    }
    public static long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for(int i = 0 ; i < roads.length ; i++){
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        Arrays.sort(degree);
        int number = 1;
        long sum = 0;
        for(int num : degree){
            sum += (long) num * number;
            number++;
        }
        return sum;
    }
}
