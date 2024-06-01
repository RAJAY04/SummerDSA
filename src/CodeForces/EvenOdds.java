package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

public class EvenOdds {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            long n = in.nextLong();
            long k = in.nextLong();

            long result = solve((int)n,(int) k);

            out.println(result);

            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static long solve(int n, int k) {
        long oddNums = (n % 2 == 1) ? ((n / 2) + 1) : (n / 2);
        boolean isOddRange = (k <= oddNums);
        long start;
        if (isOddRange) {
            start = 1 + 2 * (k - 1);
        } else {
            k -= oddNums;
            start = 2 + 2 * (k - 1);
        }
        return start;
    }
}
