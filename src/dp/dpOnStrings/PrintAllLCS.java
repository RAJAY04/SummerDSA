package dp.dpOnStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class PrintAllLCS {
    public static void main(String[] args) {
        String s = "aababbb";
        String t = "bbbaababababb";
        System.out.println(all_longest_common_subsequences(s,t));
//        System.out.println(all_longest_common_subsequences1(s,t));
    }
//    public static List<String> all_longest_common_subsequences(String s, String t)
//    {
//        int n = s.length(), m = t.length();
//        List<String> ans = memo(s,t,0,0, new StringBuilder());
//        return ans;
//    }
//
//    public static List<String> memo(String s1, String s2, int n , int m ,  StringBuilder sb){//this code works but its recursion
//        Set<String> ans = new HashSet<>();
//
//        if (n == s1.length() || m == s2.length()) {
//            ans.add(sb.toString());
//            return new ArrayList<>(ans);
//        }
//
//        if (s1.charAt(n) == s2.charAt(m)) {
//            sb.append(s1.charAt(n));
//            ans.addAll(memo(s1, s2, n + 1, m + 1,sb));
//            sb.deleteCharAt(sb.length() - 1);
//        } else {
//            List<String> l1 = memo(s1, s2, n + 1, m, sb);
//            List<String> l2 = memo(s1, s2, n, m + 1, sb);
//
//            if (!l1.isEmpty() && !l2.isEmpty()) {
//                if (l1.get(0).length() > l2.get(0).length()) {
//                    ans.addAll(l1);
//                } else if (l1.get(0).length() < l2.get(0).length()) {
//                    ans.addAll(l2);
//                } else {
//                    ans.addAll(l1);
//                    ans.addAll(l2);
//                }
//            } else if (!l1.isEmpty()) {
//                ans.addAll(l1);
//            } else {
//                ans.addAll(l2);
//            }
//        }
//
//        return new ArrayList<>(ans);
//    }
//
//    public static List<String> all_longest_common_subsequences1(String s, String t)
//    {
//        int n = s.length(), m = t.length();
//        ArrayList<String>[][] dp = new ArrayList[n][m];
//        List<String> ans = memo1(s,t,0,0, new StringBuilder(),dp);
//        Collections.sort(ans);
//        return ans;
//    }

//    public static List<String> memo1(String s1, String s2, int n , int m , StringBuilder sb, ArrayList<String>[][] dp){
//        Set<String> ans = new HashSet<>();
//
//        if (n == s1.length() || m == s2.length()) {
//            ans.add(sb.toString());
//            return new ArrayList<>(ans);
//        }
//
//        if(dp[n][m] != null)return dp[n][m];
//
//        if (s1.charAt(n) == s2.charAt(m)) {
//            sb.append(s1.charAt(n));
//            ans.addAll(memo1(s1, s2, n + 1, m + 1,sb,dp));
//            sb.deleteCharAt(sb.length() - 1);
//        } else {
//            List<String> l1 = memo1(s1, s2, n + 1, m, sb,dp);
//            List<String> l2 = memo1(s1, s2, n, m + 1, sb,dp);
//
//            if (!l1.isEmpty() && !l2.isEmpty()) {
//                if (l1.get(0).length() > l2.get(0).length()) {
//                    ans.addAll(l1);
//                } else if (l1.get(0).length() < l2.get(0).length()) {
//                    ans.addAll(l2);
//                } else {
//                    ans.addAll(l1);
//                    ans.addAll(l2);
//                }
//            } else if (!l1.isEmpty()) {
//                ans.addAll(l1);
//            } else {
//                ans.addAll(l2);
//            }
//        }
//
//        return dp[n][m] = new ArrayList<>(ans);
//    }this is nt working for some reason idk why

    public static Set<String> all(String s, String t, int[][] dp, int i, int j, Object[][] arrayOfSets)
    {

        if (arrayOfSets[i][j] != null) {
            return (Set<String>) arrayOfSets[i][j];
        }

        Set<String> set = new HashSet<>();
        if (i == 0 || j == 0) {
            set.add("");
            arrayOfSets[i][j] = set;
            return set;
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            Set<String> c = all(s, t, dp, i - 1, j - 1, arrayOfSets);
            for (String temp : c) {
                set.add(temp + s.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                set = all(s, t, dp, i - 1, j, arrayOfSets);
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                Set<String> s1 = all(s, t, dp, i, j - 1, arrayOfSets);
                set.addAll(s1);
            }
        }

        arrayOfSets[i][j] = set;
        return set;
    }

    public static List<String> all_longest_common_subsequences(String s, String t)
    {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        List<String> ans=new ArrayList<>();
        Set<String> tf=new HashSet<>();
        tf.add("dfad");
        tf.add("dfadf");

        Object[][] arrayOfSets = new Object[n+1][m+1];

        Set<String> p=all(s,t,dp,n,m,arrayOfSets);
        for(String k:p)
        {
            ans.add(k);
        }
        Collections.sort(ans);
        return ans;
    }
}
