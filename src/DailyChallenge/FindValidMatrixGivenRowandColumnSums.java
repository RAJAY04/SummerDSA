package DailyChallenge;

import java.util.Arrays;

public class FindValidMatrixGivenRowandColumnSums {
    public static void main(String[] args) {
        int[] rowSum = {5,7,10};
        int[] colSum = {8,6,8};
        restoreMatrix(rowSum, colSum);
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                matrix[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }
}
