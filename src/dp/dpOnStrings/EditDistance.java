package dp.dpOnStrings;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1,word2));
        System.out.println(tabulation(word1,word2));
        System.out.println(spaceOptimisation(word1,word2));
    }
    //dry run this quesiton to understand the concept
    //what happens during insert delete and replace
    public static int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] arr: dp) java.util.Arrays.fill(arr,-1);
        return memo(word1,word2,n,m,dp);
    }
    public static int memo(String s1, String s2,int n , int m , int[][] dp){
        if(n == 0)return m;
        if(m == 0)return n;

        if(dp[n][m] != -1)return dp[n][m];


        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            return dp[n][m] =  memo(s1,s2,n - 1,m - 1,dp);
        }else return dp[n][m] = 1 + Math.min(Math.min(memo(s1,s2,n,m - 1,dp),memo(s1,s2,n - 1,m , dp)),memo(s1,s2,n - 1, m -1 ,dp));

    }

    public static int tabulation(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = i;//when m == 0 return i
        }
        for(int j = 0 ; j <= m ; j++){
            dp[0][j] = j;//when n == 0 return j
        }


        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m ;j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] =  dp[i - 1][j - 1];
                }else dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1],dp[i - 1][j]), dp[i - 1][j - 1]);
            }
        }
        return dp[n][m];
    }
    public static int spaceOptimisation(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];


        prev[0] = 0;//when m == 0 return i
        for(int j = 0 ; j <= m ; j++){
            prev[j] = j;//when n == 0 return j
        }


        for(int i = 1; i <= n ; i++){
            cur[0] = i;
            for(int j = 1; j <= m ;j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    cur[j] =  prev[j - 1];
                }else cur[j] = 1 + Math.min(Math.min(cur[j - 1],prev[j]), prev[j - 1]);
            }
            prev = cur.clone();
        }
        return prev[m];
    }
}
