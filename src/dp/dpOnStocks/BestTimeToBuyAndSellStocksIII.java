package dp.dpOnStocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocksIII {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int result = maxProfit(prices);
        System.out.println("The maximum profit is: " + result);
        System.out.println(tabluation(prices));
        System.out.println(spaceOptimisation(prices));
        System.out.println(maxProfit1(prices));
        System.out.println(tabulation1(prices));
        System.out.println(spaceOptimisation1(prices));
    }

    public static int maxProfit(int[] prices) {
        // Initialize dp array
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return memo(prices, 0, dp, 0, 2);
    }

    // Use 'buy' as 0 or 1 to indicate whether we currently hold a stock
    //mistake : when you add transaction you also need to maintain its state too
    public static int memo(int[] prices, int i, int[][][] dp, int buy, int transactions) {
        if (i == prices.length) return 0;

        if (transactions == 0) return 0;

        if (dp[i][buy][transactions] != -1) return dp[i][buy][transactions];

        if (buy == 0) {
            int buyStock = memo(prices, i + 1, dp, 1, transactions) - prices[i];
            int skipStock = memo(prices, i + 1, dp, buy, transactions);
            dp[i][buy][transactions] = Math.max(buyStock, skipStock);
        } else {
            int sellStock = memo(prices, i + 1, dp, 0, transactions - 1) + prices[i];//never use transaction-- or --transaction because it modifies the value of current function call
            int holdStock = memo(prices, i + 1, dp, buy, transactions);
            dp[i][buy][transactions] = Math.max(sellStock, holdStock);
        }
        return dp[i][buy][transactions];
    }

    public static int tabluation(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int transaction = 2; transaction > 0; transaction--) {
                for (int buy = 0; buy < 2; buy++) {
                    if (buy == 0) {
                        int buyStock = dp[i + 1][1][transaction] - prices[i];
                        int skipStock = dp[i + 1][0][transaction];
                        dp[i][buy][transaction] = Math.max(buyStock, skipStock);
                    } else {
                        int sellStock = dp[i + 1][0][transaction - 1] + prices[i];//never use transaction-- or --transaction because it modifies the value of current function call
                        int holdStock = dp[i + 1][1][transaction];
                        dp[i][buy][transaction] = Math.max(sellStock, holdStock);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
    public static int spaceOptimisation(int[] prices){
        int[][] prev = new int[2][3];
        int[][] cur = new int[2][3];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int transaction = 2; transaction > 0; transaction--) {
                for (int buy = 0; buy < 2; buy++) {
                    if (buy == 0) {
                        int buyStock = prev[1][transaction] - prices[i];
                        int skipStock = prev[0][transaction];
                        cur[buy][transaction] = Math.max(buyStock, skipStock);
                    } else {
                        int sellStock = prev[0][transaction - 1] + prices[i];//never use transaction-- or --transaction because it modifies the value of current function call
                        int holdStock = prev[1][transaction];
                        cur[buy][transaction] = Math.max(sellStock, holdStock);
                    }
                }
            }
            prev = cur.clone();
        }
        return prev[0][2];
    }








    /////////////////////////////one more way of doing this

    public static int maxProfit1(int[] prices) {
        // Initialize dp array
        int[][] dp = new int[prices.length][4];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return memo(prices, 0, dp, 0);
    }

    // Use 'buy' as 0 or 1 to indicate whether we currently hold a stock
    //mistake : when you add transaction you also need to maintain its state too
    public static int memo(int[] prices, int i, int[][] dp, int transactions) {
        if (i == prices.length || transactions == 4) return 0;

        if (dp[i][transactions] != -1) return dp[i][transactions];

        if (transactions % 2 == 0) {
            int buyStock = memo(prices, i + 1, dp, transactions + 1) - prices[i];
            int skipStock = memo(prices, i + 1, dp, transactions);
            dp[i][transactions] = Math.max(buyStock, skipStock);
        } else {
            int sellStock = memo(prices, i + 1, dp, transactions + 1) + prices[i];//never use transaction-- or --transaction because it modifies the value of current function call
            int holdStock = memo(prices, i + 1, dp, transactions);
            dp[i][transactions] = Math.max(sellStock, holdStock);
        }
        return dp[i][transactions];
    }

    public static int tabulation1(int[] prices){
        int[][] dp = new int[prices.length + 1][5];
        for(int i = prices.length - 1 ; i >= 0; i--){
            for(int transaction = 0 ; transaction < 4;transaction++){
                if (transaction % 2 == 0) {
                    int buyStock = dp[i + 1][transaction + 1] - prices[i];
                    int skipStock = dp[i + 1][transaction];
                    dp[i][transaction] = Math.max(buyStock, skipStock);
                } else {
                    int sellStock = dp[i + 1][transaction + 1] + prices[i];//never use transaction-- or --transaction because it modifies the value of current function call
                    int holdStock = dp[i + 1][transaction];
                    dp[i][transaction] = Math.max(sellStock, holdStock);
                }
            }
        }
        return dp[0][0];
    }

    public static int spaceOptimisation1(int[] prices){
        int[] cur = new int[5];
        int[] prev = new int[5];
        for(int i = prices.length - 1 ; i >= 0; i--){
            for(int transaction = 0 ; transaction < 4;transaction++){
                if (transaction % 2 == 0) {
                    int buyStock = prev[transaction + 1] - prices[i];
                    int skipStock = prev[transaction];
                    cur[transaction] = Math.max(buyStock, skipStock);
                } else {
                    int sellStock = prev[transaction + 1] + prices[i];//never use transaction-- or --transaction because it modifies the value of current function call
                    int holdStock = prev[transaction];
                    cur[transaction] = Math.max(sellStock, holdStock);
                }
            }
            prev = cur.clone();
        }
        return prev[0];
    }
}
