package dp.dpOnStocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args) {
        int[] prices = {1, 5, 3, 6};
        int result = maxProfit(prices);
        System.out.println("The maximum profit is: " + result);
        System.out.println(tabluation(prices));
    }
    public static int maxProfit(int[] prices) {
        // Initialize dp array
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memo(prices, 0, dp, 0);
    }

    // Use 'buy' as 0 or 1 to indicate whether we currently hold a stock
    public static int memo(int[] prices, int i, int[][] dp, int buy) {
        if(i == prices.length)return 0;

        if(dp[i][buy] != -1)return dp[i][buy];

        if(buy == 0){
            int buyStock = memo(prices,i + 1, dp, 1) - prices[i];
            int skipStock = memo(prices,i + 1 , dp, buy);
            dp[i][buy] = Math.max(buyStock,skipStock);
        }else{
            int sellStock = memo(prices,i + 1, dp, 0) + prices[i];
            int holdStock = memo(prices,i + 1 , dp, buy);
            dp[i][buy] = Math.max(sellStock,holdStock);
        }
        return dp[i][buy];
    }

    public static int tabluation(int[] prices){
        int[][] dp = new int[prices.length + 1][2];
        for(int i = prices.length - 1 ; i >= 0; i--){
            for(int buy = 0; buy < 2 ; buy++){
                if(buy == 0){
                    int buyStock = dp[i + 1][1] - prices[i];
                    int skipStock = dp[i + 1][buy];
                    dp[i][buy] = Math.max(buyStock,skipStock);
                }else{
                    int sellStock = dp[i + 1][0] + prices[i];
                    int holdStock = dp[i + 1][buy];
                    dp[i][buy] = Math.max(sellStock,holdStock);
                }
            }
        }
        return dp[0][0];
    }

    public static int spaceOptimisation(int[] prices){
        int nextZero = 0, nextOne = 0, curZero = 0 , curOne = 0;//can use a array of 2 vars instead
        for(int i = prices.length - 1 ; i >= 0; i--){
            for(int buy = 0; buy < 2 ; buy++){
                if(buy == 0){
                    int buyStock = nextOne - prices[i];
                    int skipStock = nextZero;
                    curZero = Math.max(buyStock,skipStock);
                }else{
                    int sellStock = nextZero + prices[i];
                    int holdStock = nextOne;
                    curOne = Math.max(sellStock,holdStock);
                }
            }
            nextZero = curZero;
            nextOne = curOne;
        }
        return nextZero;
    }

    public static int removeBuyForLoop(int[] prices) {
        int nextZero = 0, nextOne = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            int curZero = Math.max(nextOne - prices[i], nextZero);
            int curOne = Math.max(nextZero + prices[i], nextOne);
            nextZero = curZero;
            nextOne = curOne;
        }

        return nextZero;
    }
}
