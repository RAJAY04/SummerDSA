package DailyChallenge;

public class MagicSquaresInAgrid {
    public static void main(String[] args) {
        int[][] grid = {{4,7,8}
                        ,{9,5,1},
                        {2,3,6}};
        System.out.println(numMagicSquaresInside(grid));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row < 3 || col < 3) return 0;
        int res = 0;
        for (int r = 0; r < row - 2; r++) {
            for (int c = 0; c < col - 2; c++) {
                if (isMagic(grid, r, c)) res++;
            }
        }
        return res;
    }

    public static boolean isMagic(int[][] grid, int r, int c) {
        // Check if all numbers are unique and within 1 to 9
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[r + i][c + j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }
        int sum1 = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        int sum2 = grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2];
        int sum3 = grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2];
        int sum4 = grid[r][c] + grid[r + 1][c] + grid[r + 2][c];
        int sum5 = grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1];
        int sum6 = grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2];
        int sumDiag1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int sumDiag2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];

        return (sum1 == 15 && sum2 == 15 && sum3 == 15 &&
                sum4 == 15 && sum5 == 15 && sum6 == 15 &&
                sumDiag1 == 15 && sumDiag2 == 15);
    }

}
