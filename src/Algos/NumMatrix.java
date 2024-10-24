package Algos;

class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        prefix = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m ; j++){
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;col1++;row2++;col2++;//1 based preSum array
        int fullSum = prefix[row2][col2];
        int sub1 = prefix[row1 - 1][col2];
        int sub2 = prefix[row2][col1 - 1];
        int overLap = prefix[row1 - 1][col1 - 1];
        return fullSum - sub1 - sub2 + overLap;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                          {5, 6, 3, 2, 1},
                          {1, 2, 0, 1, 5},
                          {4, 1, 0, 1, 7},
                          {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}