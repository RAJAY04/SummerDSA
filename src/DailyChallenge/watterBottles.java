package DailyChallenge;

public class watterBottles {
    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;
        System.out.println(numWaterBottles(numBottles,numExchange));
        System.out.println(numWaterBottles1(numBottles,numExchange));
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0 ;
        while(numBottles >= numExchange){
            int newBottles = numBottles  / numExchange;
            int remBottles = numBottles % numExchange;
            ans += newBottles * numExchange;
            numBottles = remBottles + newBottles;
        }
        ans += numBottles;
        return ans;
    }
    //this logic is also simpler
    //while(numBottles >= numExchange){
    //            int remainedFullWaterBottles = numBottles % numExchange;
    //            int newFullWaterBottles = numBottles / numExchange;
    //            res += newFullWaterBottles;
    //            numBottles = remainedFullWaterBottles + newFullWaterBottles;// prepare for next round
    //        }
    //        return res;

    //O(1) approach
    //just intuion is instead of drinking 3 and getting 1 back, we can directly say drinking 3 but still remaining 1
    //if you only have 2 empty bottles remaining(the edge case), you can NOT exchange it for 1 (bottle) unit of water.
    //(numExchange - 1) empty bottles can exchange 1 (bottle) unit of water, unless you have only numExchange left.

    public static int numWaterBottles1(int numBottles, int numExchange) {
        return numBottles + ((numBottles - 1) / (numExchange - 1));//-1 in num to avoid edge case, that at least 1 bottle shsould be left
    }//to remove numExchange -1 bottles we need to have at least one bottle remaining
}
