package LeetCodeContests.Weekly406;

import java.util.Arrays;

public class MinCostForCuttingCakeI {
    public static void main(String[] args) {
        int m = 5, n = 4;
        int[] horizontalCut = {1,2,4};
        int[] verticalCut = {1,3};
        System.out.println(new MinCostForCuttingCakeI().minimumCost(m,n,horizontalCut,verticalCut));
    }
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        long ans = 0;

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int i = verticalCut.length - 1, j = horizontalCut.length - 1;
        int hb = 1, vb = 1;//no of horizontal and vertical blocks
        //when we do vertical cut we increase the no of vertical blocks and vice versa
        //so we multiply the cost of cutting with the no of opposite blocks
        while(i >= 0 && j >= 0){
            if(verticalCut[i] > horizontalCut[j]){
                ans += verticalCut[i] * hb;
                vb++;
                i--;
            }else{
                ans += horizontalCut[j] * vb;
                hb++;
                j--;
            }
        }
        while(j >= 0){
            ans += horizontalCut[j--] * vb;
        }

        while(i >= 0){
            ans += verticalCut[i--] * hb;
        }
        return ans;
    }
}
