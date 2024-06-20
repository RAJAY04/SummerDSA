package DailyChallenge;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {5,4,3,2,1,1000000000};
        int m = 2;

        MagneticForceBetweenTwoBalls instance = new MagneticForceBetweenTwoBalls();
        int result = instance.maxDistance(position, m);
        System.out.println("The maximum distance is: " + result);
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);//without sorting we cant place the first ball in min pos
        long s = 1 ;
        long e = position[position.length - 1];
        long ans = 1;
        while(s < e){
            long mid = s + ( e - s )/2;
            if(isPossible(position,mid,m)){
                ans = mid;
                s = mid + 1;
            }else e = mid;
        }
        return (int)ans;
    }
    public static boolean isPossible(int[] position , long distance , int m){
        int index = 0;
        int ballCount = 1;
        for(int i = 1; i < position.length; i++){
            if(position[i] - position[index] >= distance){
                ballCount++;
                index = i;
            }
        }
        return ballCount >= m;
    }
}
