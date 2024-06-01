package CodeForces;

import java.util.*;
import java.io.*;

public class Main{
    //public static void main(String[] args) {
    //        Scanner scanner = new Scanner(System.in);
    //        int testCases = scanner.nextInt(); // Read the number of test cases
    //
    //        while (testCases-- > 0) {
    //            int n = scanner.nextInt(); // Read the value of n for each test case
    //            System.out.println(1); // Print the result for each test case
    //        }
    //
    //        scanner.close(); // Close the scanner to prevent resource leak
    //    }
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
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int n = in.nextInt();
                //long fact = factorial(n);
                out.println(1);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}


