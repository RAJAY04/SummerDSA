package LeetCodeContests.Weekly401;

public class FirstChildWhoHasBalls {
    public static void main(String[] args) {
        int n = 5;
        int k = 5;
        System.out.println(numberOfChild(n,k));
    }
    public static int numberOfChild(int n, int k) {
        if(k < n - 1)return k;
        int i = 0;
        while(k > 0){
            i++;
            k--;
            if(i == n - 1){
                while(k > 0){
                    i--;
                    k--;
                    if(i == 0)break;
                }
            }
        }
        return i;
    }
}
