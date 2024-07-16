package LCVirtualContests.Biweekly128;

import java.util.Arrays;

public class MinRecToCoverPoints {
    public static void main(String[] args) {
        int[][] points = {{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}};
        int w = 2;
        System.out.println(minRectanglesToCoverPoints(points, w));

    }

    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        int count = 0;
        int n = points.length;
        int[] x = new int[n];
        for(int i = 0 ; i < points.length; i++){
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int ans = 0;
        int i = 0 , j = 1;
        while(i < points.length){
            while(j < n && x[j] - x[i] <= w){
                j++;
            }
            ans++;
            i = j;
            j++;
        }
        return ans;
    }
}
