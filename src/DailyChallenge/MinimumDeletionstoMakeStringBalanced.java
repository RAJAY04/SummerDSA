package DailyChallenge;

public class MinimumDeletionstoMakeStringBalanced {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab")); // Should print 2
        System.out.println(minimumDeletions1("aababbab")); // Should print 2


    }

    public static int minimumDeletions(String s) {
            int n = s.length();
            int[] aCountRight = new int[n];

            for (int i = n - 2; i >= 0; i--) {
                aCountRight[i] = aCountRight[i + 1];//dont inculude cur index
                if (s.charAt(i + 1) == 'a') {
                    aCountRight[i]++;
                }
            }

            int bCountLeft = 0;
            int res = n;

            for (int i = 0; i < n; i++) {
                res = Math.min(res, bCountLeft + aCountRight[i]);
                if (s.charAt(i) == 'b') {
                    bCountLeft++;
                }
            }

            return res;
    }

    public static int minimumDeletions1(String s) {
        int n = s.length();
        int rightAcount = 0;
        for (int i = 0; i < n; i++) {
            rightAcount += (s.charAt(n - i - 1) == 'a' ? 1 : 0);
        }
        int res = Integer.MAX_VALUE;
        int leftBCount = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a')rightAcount--;
            int operation = leftBCount + rightAcount;
            res = Math.min(res,operation);
            if(s.charAt(i) == 'b')leftBCount++;
        }
        return res;
    }
}
