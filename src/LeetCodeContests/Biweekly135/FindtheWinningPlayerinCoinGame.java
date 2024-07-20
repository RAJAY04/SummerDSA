package LeetCodeContests.Biweekly135;

public class FindtheWinningPlayerinCoinGame {
    public static void main(String[] args) {
        int x = 6;
        int y = 4;
        System.out.println(losingPlayer(x,y));
    }

    public static String losingPlayer(int x, int y) {
        int i = 0 ;
        while(x > 0 && y > 3){
            x-= 1;
            y-= 4;
            i++;
        }
        if(i % 2 == 1)return "Alice";
        return "Bob";
    }
}
