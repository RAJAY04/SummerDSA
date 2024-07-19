package DailyChallenge;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumberInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8}
                         ,{9,11,13},
                          {15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] cols = new int[m];
        Arrays.fill(cols, Integer.MIN_VALUE);
        int[] rows = new int[n];
        Arrays.fill(rows,Integer.MAX_VALUE);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                rows[i] = Math.min(matrix[i][j],rows[i]);
                cols[j] = Math.max(matrix[i][j],cols[j]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(rows[i] == cols[j])res.add(rows[i]);
            }
        }
        return res;

    }

}
