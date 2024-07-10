package DailyChallenge;

public class CrawlerLogFolder {
    public static void main(String[] args) {

    }

    //brute force would be using a stack
    public static int minOperations(String[] logs) {
        int count = 0;
        for(int i = 0 ; i < logs.length; i++){
            if(logs[i].length() == 2 && logs[i].charAt(0) == '.')continue;
            else if((logs[i].charAt(0) <= 'z' && logs[i].charAt(0) >= 'a') || (logs[i].charAt(0) >= '0' && logs[i].charAt(0) <= '9'))count++;
            else count--;
            if(count < 0)count = 0;
        }
        if(count < 0)return 0;
        return count;
    }

    public int minOperations1(String[] logs) {
        int res = 0;//more readable approach
        for (String s : logs) {
            if (s.equals("../")) res = Math.max(0, --res);
            else if (s.equals("./")) continue;
            else res++;
        }
        return res;
    }
}
