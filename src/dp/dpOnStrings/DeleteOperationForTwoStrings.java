package dp.dpOnStrings;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int lcs = LongestCommonSubsequence(word1, word2);
        if(l1 == l2)return (l1 + l2) - 2 * lcs;
        else if(l1 > l2)return l1 - lcs;
        else return l2 - lcs;
    }

    public static int LongestCommonSubsequence(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2 ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[l1][l2];
    }
}
