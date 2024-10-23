package DSAworkshop14sep;

public class PreSum {
    public static void main(String[] args) {
        //give the example of fruit shop
        String s = "abacaba";

        int[][] queries = {
                {0, 4, 'a'},
                {1, 3, 'b'},
                {2, 6, 'c'},
        };

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            char target = (char) query[2];
            System.out.println("Count of '" + target + "' from index " + start + " to " + end + ": " + helper(s, start, end, target));
        }
    }

    public static int helper(String s, int start, int end, char target) {
        int n = s.length();
        int[][] preSum = new int[n][26];

        preSum[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                preSum[i][j] = preSum[i - 1][j];
            }
            preSum[i][s.charAt(i) - 'a']++;
        }

        int tar = target - 'a';

        if (start == 0) {
            return preSum[end][tar];
        } else {
            return preSum[end][tar] - preSum[start - 1][tar];
        }
    }
}
