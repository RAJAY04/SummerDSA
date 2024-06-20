package dp.dpOnStocks;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = tabluation(prices, fee);
        System.out.println("Maximum profit after transaction fees: " + result);
    }

    public static int tabluation(int[] prices,int fee){
        int[][] dp = new int[prices.length + 1][2];
        for(int i = prices.length - 1 ; i >= 0; i--){
            for(int buy = 0; buy < 2 ; buy++){
                if(buy == 0){
                    int buyStock = dp[i + 1][1] - prices[i];
                    int skipStock = dp[i + 1][buy];
                    dp[i][buy] = Math.max(buyStock,skipStock);
                }else{
                    int sellStock = dp[i + 1][0] + prices[i] - fee;
                    int holdStock = dp[i + 1][buy];
                    dp[i][buy] = Math.max(sellStock,holdStock);
                }
            }
        }
        return dp[0][0];
    }
}
