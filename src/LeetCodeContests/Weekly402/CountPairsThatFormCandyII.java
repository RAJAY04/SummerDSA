package LeetCodeContests.Weekly402;

public class CountPairsThatFormCandyII {
    public static void main(String[] args) {
        int[] hours =  {24,72,48};
        System.out.println(countCompleteDayPairs(hours));
    }
    public static long countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        int[] rem = new int[24];
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int remainder = hours[j] % 24;
            int needed = (24 - remainder) % 24;

            ans += rem[needed];

            rem[remainder]++;
        }

        return ans;
    }
}
