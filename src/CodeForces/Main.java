package CodeForces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        String t = in.next();
        PrintWriter cout = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t.length(); i++) {
            char c = Character.toLowerCase(t.charAt(i));
            if (!isVowel(c)) {
                sb.append('.');
                sb.append(c);
            }
        }

        cout.println(sb.toString());
        cout.flush();

    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y';
    }
}


