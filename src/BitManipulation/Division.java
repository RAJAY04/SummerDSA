package BitManipulation;

public class Division {
    public static void main(String[] args) {
        Division division = new Division();
        System.out.println(division.divide(-2147483648,-1));
    }
    public static int divide(int dividend, int divisor) {

        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            int pow = 0;
            while (n >= (d << (pow + 1))) {
                pow++;
            }
            ans += 1L << pow;
            n -= d << pow;
        }

        if (isNegative) {
            ans = -ans;
        }

        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }
}
