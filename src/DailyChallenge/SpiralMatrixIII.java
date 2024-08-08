package DailyChallenge;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;
        int[][] result = spiralMatrixIII(rows, cols, rStart, cStart);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        List<int[]> res = new ArrayList<>();
        int len = 0 , d = 0;
        res.add(new int[]{r0,c0});
        while(res.size() < R * C){
            if(d == 0 || d == 2)len++;
            for(int i = 0 ;i < len; i++){
                r0 += dx[d];
                c0 += dy[d];
                if(r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) res.add(new int[]{r0,c0});
            }
            d = (d + 1) % 4;
        }
        return res.toArray(new int[R * C][2]);
    }
}
