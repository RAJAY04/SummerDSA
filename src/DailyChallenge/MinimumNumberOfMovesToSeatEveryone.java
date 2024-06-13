package DailyChallenge;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    public static void main(String[] args) {
        int[] seats = {2,3,4};
        int[] students = {1,2,3};
        System.out.println(minMovesToSeat(seats,students));
    }
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for(int i = 0 ; i < seats.length ; i++){
            count += Math.abs(seats[i] - students[i]);
        }
        return count;
    }
}
