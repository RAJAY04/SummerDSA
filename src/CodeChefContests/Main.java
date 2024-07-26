package CodeChefContests;

import java.util.*;
import java.io.*;

public class Main {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
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

    public static void main (String[] args) throws java.lang.Exception {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                char[][] mat = new char[n][n];
                for(int i = 0 ;i < n; i++){
                    for(int j = 0 ;j < n; j++){
                        mat[i] = in.nextLine().toCharArray();
                    }
                }
                if (n == k) {
                    out.println(mat[0][0]);
                } else {
                    char[][] res = new char[n / k][n / k];
                    for (int i = 0; i < n; i += k) {
                        for (int j = 0; j < n; j += k) {
                            res[i / k][j / k] = mat[i][j];
                        }
                    }
                    for (int i = 0; i < res.length; i++) {
                        for (int j = 0; j < res[0].length; j++) {
                            out.print(res[i][j]);
                        }
                        System.out.println();
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
