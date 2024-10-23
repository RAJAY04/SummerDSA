package DSAworkshop14sep;

public class BrianKarnighans {
    public static void main(String[] args) {
        int n = 324;
        System.out.println(countSetBits(n));
        System.out.println(Integer.toBinaryString(n));
        swap();
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void swap(){
        int a = 10, b = 20;
        System.out.println(a);
        System.out.println(b);

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        a = 10;
        b = 20;

        System.out.println(a);
        System.out.println(b);
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }
}
