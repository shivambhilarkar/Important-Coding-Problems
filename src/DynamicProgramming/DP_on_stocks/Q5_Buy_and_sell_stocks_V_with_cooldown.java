package DynamicProgramming.DP_on_stocks;



public class Q5_Buy_and_sell_stocks_V_with_cooldown {


    /**
     * Recursive
     */
    public int getMaxProfitRecursive(int[] prices, int cooldown) {
        return getMaxProfitRecursive(prices, 0, 0, cooldown);
    }

    private int getMaxProfitRecursive(int[] prices, int index, int isBuy, int cooldown) {
        if (index >= prices.length) return 0;

        int profit = 0;
        if (isBuy == 0) {
            int canBuyNow = -prices[index] + getMaxProfitRecursive(prices, index + 1, 1, cooldown);
            int dontBuyNow = getMaxProfitRecursive(prices, index + 1, 0, cooldown);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = prices[index] + getMaxProfitRecursive(prices, index + cooldown, 0, cooldown);
            int dontSellNow = getMaxProfitRecursive(prices, index + 1, 1, cooldown);
            profit = Math.max(canSellNow, dontSellNow);
        }
        return profit;
    }


    /**
     * Memoization
     */
    public int getMaxProfitMemoization(int[] prices, int cooldown) {
        int[][] dp = new int[prices.length][2];
        return getMaxProfitMemoization(prices, 0, 0, cooldown, dp);
    }

    private int getMaxProfitMemoization(int[] prices, int index, int isBuy, int cooldown, int[][] dp) {
        if (index >= prices.length) return 0;

        if (dp[index][isBuy] != 0) {
            return dp[index][isBuy];
        }

        int profit = 0;
        if (isBuy == 0) {
            int canBuyNow = -prices[index] + getMaxProfitMemoization(prices, index + 1, 1, cooldown, dp);
            int dontBuyNow = getMaxProfitMemoization(prices, index + 1, 0, cooldown, dp);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = prices[index] + getMaxProfitMemoization(prices, (index + 1 + cooldown), 0, cooldown, dp);
            int dontSellNow = getMaxProfitMemoization(prices, index + 1, 1, cooldown, dp);
            profit = Math.max(canSellNow, dontSellNow);
        }
        dp[index][isBuy] = profit;
        return profit;
    }



    /**
     * Tabulation
     * current solution is for cooldown for 1 day.
     * implement solution to support for k cooldown days.
     */
    public int getMaxProfitTabulation(int[] prices, int cooldown){

        int[][] dp = new int[prices.length + 2][2];
        for(int index = prices.length - 1; index >= 0; index--){
            for(int isBuy = 0; isBuy < 2; isBuy++){
                int profit = 0;
                if(isBuy == 0){
                    int canBuyNow = -prices[index] + dp[index+1][1];
                    int dontBuyNow = dp[index+1][0];
                    profit = Math.max(canBuyNow, dontBuyNow);
                }else{
                    // int canSellNow = 0;
                    // if(index + 1 + cooldown < prices.length){
                    //     canSellNow = prices[index] + dp[index + 1 + cooldown][0];
                    // }

                    int canSellNow = prices[index] + dp[index + 1 + cooldown][0];
                    int dontSellNow = dp[index + 1][1];
                    profit = Math.max(canSellNow, dontSellNow);
                }
                dp[index][isBuy] = profit;
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {

    }


}
