package DailyChallenge;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[] rating = {2,5,3,4,1};
        System.out.println(numTeams(rating));
    }
    public static int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            int smallerLeft = 0;
            int greaterRight = 0;
            int smallerRight = 0;
            int greaterLeft = 0;
            for(int j = i - 1 ; j >= 0; j--){
                if(rating[j] > rating[i])greaterLeft++;
                else smallerLeft++;
            }
            for(int j = i + 1; j < n; j++){
                if(rating[j] > rating[i])greaterRight++;
                else smallerRight++;
            }
            ans += (greaterLeft * smallerRight) + (smallerLeft * greaterRight);
        }
        return ans;
    }
}
