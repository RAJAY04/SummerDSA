package DailyChallenge;

import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {
    public static void main(String[] args) {
        HandOfStraights obj = new HandOfStraights();
        int[] hand = {1,1,2,2,3,3};
        int groupSize = 3;
        System.out.println(obj.isNStraightHand(hand,groupSize));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length , k = groupSize;
        if(n % k != 0 || n < k)return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for(int num: hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int groups = n /k;
        int required = 0,count = 0;
        for(int i = 0 ; i < n ; i++){
            if(i > 0 && map.getOrDefault(hand[i - 1],0)== 0 && hand[i] == hand[i - 1])continue;
            required = hand[i];
            count = 0;
            while(map.containsKey(required) && map.getOrDefault(required,0) != 0){
                count++;
                map.put(required,map.get(required)-1);
                required++;
                if(count == k){
                    groups--;
                    break;
                }
            }
            if(count % k != 0)return false;
            if(groups == 0)return true;

        }if(count != k)return false;
        return true;

    }
}
