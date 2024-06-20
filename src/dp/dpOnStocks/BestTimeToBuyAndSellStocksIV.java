package dp.dpOnStocks;

public class BestTimeToBuyAndSellStocksIV {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2; // Example value of k

        int result = tabulation1(k, prices);
        System.out.println("Maximum profit with at most " + k + " transactions: " + result);
    }
    public static int tabulation1(int k,int[] prices){
        int[][] dp = new int[prices.length + 1][(2 * k) + 1];
        for(int i = prices.length - 1 ; i >= 0; i--){
            for(int transaction = 0 ; transaction < 2 * k;transaction++){
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
}
