package CodeForces.DIV2_949;
import java.io.*;
import java.util.StringTokenizer;

public class A {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
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
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                int l = in.nextInt();
                int r = in.nextInt();
                long ans = solve(l, r);
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int solve(int l, int r) {
        int p = 2;
        int x;
        if (r % 2 == 1) {
            x = r - 1;
        } else {
            x = r;
        }
        int count = 0;
        while (x / p != 1) {
            x /= p;
            count++;
        }

        return count + 1;
    }
}
