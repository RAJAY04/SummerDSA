package LeetCodeContests.Weekly402;

public class CountPairsThatFormCandyI {
    public static void main(String[] args) {
        int[] hours =  {12,12,30,24,24};
        System.out.println(countCompleteDayPairs(hours));
    }
    public static int countCompleteDayPairs(int[] hours) {
        double count = 0;
        double h1 , h2;
        for(int i = 0 ; i < hours.length - 1; i++){
            h1 = hours[i];
            for(int j = i + 1 ; j < hours.length; j++){
                h2 = hours[j];
                if(( h1+ h2) % 24 == 0){
                    count++;
                }
            }
        }
        return (int)count;
    }
}
