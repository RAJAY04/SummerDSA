package GFGcontests;

import java.util.Arrays;

public class TrafficLightes {
    public static void main(String[] args) {
        int n = 1;
        int q = 2;
        int[][] queries = {{1,1},{1,1}};
        System.out.println(trafficLights(n,q,queries));
    }
    public static String trafficLights(int n, int q, int[][] queries) {
        int[] freq = new int[n];
        for(int i = 0 ; i < q; i++){
            int start = queries[i][0] - 1;
            int end = queries[i][1] - 1;
            for(int j = start ; j <= end; j++){
                freq[j] += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            if(freq[i] % 3 == 0){
                sb.append('R');
            }else if(freq[i] % 3 == 1){
                sb.append('Y');
            }else sb.append('G');
        }
        return sb.toString();
    }
}
