package DailyChallenge;

public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers = {{1,2},{2,5},{4,3}};
        System.out.println(averageWaitingTime(customers));
    }
    public static double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double sum = customers[0][1];
        double curWaitTime = customers[0][1];
        double curTime = customers[0][0] + customers[0][1];
        for(int i = 1 ; i < n ; i++){
            curWaitTime = (curTime - customers[i][0]) >= 0  ?  curTime - customers[i][0] : 0;
            curWaitTime += customers[i][1];
            sum += curWaitTime;
            curTime = curWaitTime + customers[i][0];
        }
        return (double)sum/(double)n;
    }
}
