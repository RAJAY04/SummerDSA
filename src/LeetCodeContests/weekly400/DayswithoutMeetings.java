package LeetCodeContests.weekly400;

import java.util.Arrays;

public class DayswithoutMeetings {
    public static void main(String[] args) {
        DayswithoutMeetings dayswithoutMeetings = new DayswithoutMeetings();
//        int[][] meetings = {{22,31},{7,42},{30,46},{9,33},{9,18},{23,39},{4,8},{18,19}};
        int[][] meetings = {{5,7},{1,3},{9,10}};
        System.out.println(dayswithoutMeetings.countDays(50, meetings));
    }
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(meetings));
        int ans = 0;
        int largest = - 1;
        if(meetings[0][0] > 1){
            ans += meetings[0][0] - 1;
        }
        largest = Math.max(largest,meetings[0][1]);
        for(int i = 0 ; i < meetings.length-1; i++){
            largest = Math.max(largest,meetings[i + 1][1]);
            if(meetings[i + 1][0] <= meetings[i][1] || largest > meetings[i+1][0])continue;
            else ans += meetings[i + 1][0] - meetings[i][1] - 1;
        }
        if(largest < days)ans += days - largest;
        return ans;
    }
    public static int countDays1(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(meetings));

        int ans = 0;
        int largest = 0;
        if (meetings[0][0] > 1) {
            ans += meetings[0][0] - 1;
        }

        largest = meetings[0][1];

        for (int i = 0; i < meetings.length - 1; i++) {
            largest = Math.max(largest, meetings[i][1]);
            if (meetings[i + 1][0] > largest + 1) {
                ans += meetings[i + 1][0] - largest - 1;
            }
            largest = Math.max(largest, meetings[i + 1][1]);
        }

        if (largest < days) {
            ans += days - largest;
        }

        return ans;
    }
}
