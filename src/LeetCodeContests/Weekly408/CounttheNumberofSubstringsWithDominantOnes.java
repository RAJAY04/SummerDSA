//package LeetCodeContests.Weekly408;
//
//public class CounttheNumberofSubstringsWithDominantOnes {
//    public static void main(String[] args) {
//        String s = "101101";
//        System.out.println(numberOfSubstrings(s));
//    }
//
//    public static int numberOfSubstrings(String s) {
//        int n = s.length();
//        char[] arr = s.toCharArray();
//        int[] pre = new int[n];
//        int[] suf = new int[n];
//        for (int i = 0; i < n; i++) {
//            pre[i] = arr[i] - '0';
//            suf[n - i - 1] = arr[n - i - 1] - '0';
//            if (i > 0) {
//                pre[i] += pre[i - 1];
//                suf[n - i - 1] += suf[n - i];
//            }
//        }
//        long res = 0;
//    }
//}
