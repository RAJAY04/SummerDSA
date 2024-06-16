package dp.dpOnStrings;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "eke";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }
    //simple idea similar to printing LCS using backtracking the tabulation array
    //we will start from the end and move to the start
    //if the characters are same we will add that character to the result and move diagonally up
    //if the characters are different we will move to the cell with maximum value
    //if we are at the top row we will move left
    //if we are at the leftmost column we will move up
    //we will keep on adding the characters to the result and finally return the result

    public static String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2 ; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while( l1 > 0 && l2 > 0){
            if(str1.charAt(l1 - 1) == str2.charAt(l2 - 1)){
                sb.append(str1.charAt(l1 - 1));
                l1--;l2--;
            }else if(dp[l1 - 1][l2] > dp[l1][l2 - 1]){
                sb.append(str1.charAt(l1 - 1));
                l1--;
            }else{
                sb.append(str2.charAt(l2 - 1));
                l2--;
            }
        }
        while(l1 > 0){
            sb.append(str1.charAt(l1 - 1));
            l1--;
        }
        while(l2 > 0){
            sb.append(str2.charAt(l2 - 1));
            l2--;
        }
        return sb.reverse().toString();
    }
}
