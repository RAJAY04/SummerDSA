package DailyChallenge;

public class SubstirngWithinBudget {
    public static void main(String[] args) {
        String s = "krrgw";
        String t = "zjxss";
        int maxCost = 19;
        System.out.println(equalSubstring(s, t, maxCost));
    }
    public static int equalSubstring(String s, String t, int maxCost) {
        if(s.equals(t)){
            return 1;
        }

        int i = 0 , j = 0 ,curCost = 0 ,max = -1;;
        while(j < s.length() && i < s.length()){
            int cost = Math.abs(s.charAt(j) - t.charAt(j));
            curCost += cost;
            j++;
            while(i < s.length() && curCost > maxCost){
                curCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            max = Math.max(max,j - i);
        }
        return max;
    }
}
