package DailyChallenge;

public class PassThePillow {
    public static void main(String[] args) {
        int n = 3;
        int time = 5;
        System.out.println(passThePillow(n, time));
    }
    public static int passThePillow(int n, int time) { //O(1) time and space
        int completed = time / ( n - 1);
        int remaining = time % ( n - 1);
        if(completed % 2 == 1)return n - remaining;
        return remaining + 1;
    }
}
