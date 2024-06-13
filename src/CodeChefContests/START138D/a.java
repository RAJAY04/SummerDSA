package CodeChefContests.START138D;


import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class a {
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

    public static void main(String[] args) {
        try {
            a.FastReader in = new a.FastReader();
            a.FastWriter out = new a.FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                int n = in.nextInt();
                String s = in.nextLine();
                boolean flag = isValid(s, n);
                if (flag) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static boolean isValid(String s, int n) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                count = 0;
            } else {
                count++;
            }

            if (count >= 4) return false;
        }
        return true;
    }
}
