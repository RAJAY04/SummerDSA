package dp.dp2D;

public class GeeksTraining {
    public static void main(String[] args) {
        int points[][] = {{8, 7, 6}, {0, 4, 5}, {1, 2, 9}, {8, 3, 0}};
        System.out.println(maximumPoints(points,4));
        System.out.println(tabulation(points,4));
    }
    public static int maximumPoints(int points[][],int N){
        int[][] dp = new int[N][4];//3 is enough
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < 3 ; j++){
                dp[i][j] = -1;
            }
        }

        return memo(points,N - 1,dp,3);
    }

    public static int memo(int[][] points, int n, int[][] dp, int avoid){
            if(n == 0){
            int max = 0;
            for(int i = 0 ; i< 3 ; i++){
                if(i == avoid)continue;
                max = Math.max(points[n][i],max);
            }
            return max;
        }

        if(avoid != 3 && dp[n][avoid] != -1)return dp[n][avoid];//the problem was if i use -1 i though i was getting index out of bound
        //but that was not in this line but in the last line were we are storing the value in dp[n][avoid]
        int max = 0 , point = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(i == avoid)continue;
            point = memo(points,n - 1, dp,i) + points[n][i];
            max = Math.max(max,point);
        }
        return dp[n][avoid] = max;
    }

    public static int tabulation(int[][] points, int n) {
        int[][] dp = new int[n][3];

        // Initialize the first day
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];

        // Fill the dp array
        for (int day = 1; day < n; day++) {
            for (int avoid = 0; avoid < 3; avoid++) {
                int max = 0; // Reset max for each 'avoid' task
                for (int task = 0; task < 3; task++) {
                    if (task == avoid) continue; // Skip the task to avoid
                    int point = dp[day - 1][task] + points[day][task];
                    max = Math.max(max, point); // Calculate max points for the day avoiding 'avoid' task
                }
                dp[day][avoid] = max; // Update dp[day][avoid] with max value
            }
        }

        // Return the maximum points that can be obtained on the last day
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }


}
