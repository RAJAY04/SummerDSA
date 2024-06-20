package dp.dpOnStocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocksWithCoolDown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2}; // Example prices array

        int result = maxProfit(prices);
        System.out.println("Maximum profit: " + result);
        System.out.println(tabluation(prices));
        System.out.println(tabluation1(prices));
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
        if(i >= prices.length)return 0;

        if(dp[i][buy] != -1)return dp[i][buy];

        if(buy == 0){
            int buyStock = memo(prices,i + 1, dp, 1) - prices[i];
            int skipStock = memo(prices,i + 1 , dp, buy);
            dp[i][buy] = Math.max(buyStock,skipStock);
        }else{
            int sellStock = memo(prices,i + 2, dp, 0) + prices[i];
            int holdStock = memo(prices,i + 1 , dp, buy);
            dp[i][buy] = Math.max(sellStock,holdStock);
        }
        return dp[i][buy];
    }
    public static int tabluation(int[] prices){
        int[][] dp = new int[prices.length + 2][2];//+ 2
        for(int i = prices.length - 1 ; i >= 0; i--){
            for(int buy = 0; buy < 2 ; buy++){
                if(buy == 0){
                    int buyStock = dp[i + 1][1] - prices[i];
                    int skipStock = dp[i + 1][buy];
                    dp[i][buy] = Math.max(buyStock,skipStock);
                }else{
                    int sellStock = dp[i + 2][0] + prices[i];
                    int holdStock = dp[i + 1][buy];
                    dp[i][buy] = Math.max(sellStock,holdStock);
                }
            }
        }
        return dp[0][0];
    }

    public static int tabluation1(int[] prices){//just ommit the internal for loop
        int[][] dp = new int[prices.length + 2][2];//+ 2
        for(int i = prices.length - 1 ; i >= 0; i--){
            int buyStock = dp[i + 1][1] - prices[i];
            int skipStock = dp[i + 1][0];
            dp[i][0] = Math.max(buyStock,skipStock);
            int sellStock = dp[i + 2][0] + prices[i];
            int holdStock = dp[i + 1][1];
            dp[i][1] = Math.max(sellStock,holdStock);
        }
        return dp[0][0];
    }

    //we need to carry 3 diff arrs to space optimise this as we have index + 1, index + 2 so ur wish if u wanna do it or not


}
