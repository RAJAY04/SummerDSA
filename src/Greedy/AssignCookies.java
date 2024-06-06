package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        if(s.length == 0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i = 0 , j = 0 , count = 0;
        while( i < n && j < m){
            if(g[i] <= s[j]){
                count++;
                i++;
                j++;
            }else if(g[i] > s[j]){
                j++;
            }
        }
        return count;
    }
}
