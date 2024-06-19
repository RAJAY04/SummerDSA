package dp.dpOnStocks;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println("The maximum profit is: " + result);
    }
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0, curCost = 0;
        for(int i = 1; i < prices.length; i++){
            curCost = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit,curCost);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}
