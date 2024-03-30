package DynamicProgramming.DP_on_stocks;

public class Q4_Buy_and_sell_stocks_IV_k_transactions {


    /**
     * Recursive
     */
    public int getMaxProfitRecursive(int[] prices, int transactions) {
        return getMaxProfitRecursive(prices, 0, 0, transactions);
    }

    private int getMaxProfitRecursive(int[] prices, int index, int isBuy, int transaction) {
        if (index == prices.length || transaction == 0) {
            return 0;
        }

        int profit = 0;
        if (isBuy == 0) {
            int canBuyNow = -prices[index] + getMaxProfitRecursive(prices, index + 1, 1, transaction);
            int dontBuyNow = getMaxProfitRecursive(prices, index + 1, 0, transaction);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = prices[index] + getMaxProfitRecursive(prices, index + 1, 0, transaction - 1);
            int dontSellNow = getMaxProfitRecursive(prices, index + 1, 1, transaction);
            profit = Math.max(canSellNow, dontSellNow);
        }
        return profit;
    }

    /**
     * Memoization
     */
    public int getMaxProfitMemoization(int[] prices, int transaction) {
        int[][][] dp = new int[prices.length][2][transaction + 1];

        return getMaxProfitMemoization(prices, 0, 0, transaction, dp);
    }

    private int getMaxProfitMemoization(int[] prices, int index, int isBuy, int transaction, int[][][] dp) {
        if (index == prices.length || transaction == 0) {
            return 0;
        }

        if (dp[index][isBuy][transaction] != 0) {
            return dp[index][isBuy][transaction];
        }


        int profit = 0;
        if (isBuy == 0) {
            int canBuyNow = -prices[index] + getMaxProfitMemoization(prices, index + 1, 1, transaction, dp);
            int dontBuyNow = getMaxProfitMemoization(prices, index + 1, 0, transaction, dp);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = prices[index] + getMaxProfitMemoization(prices, index + 1, 0, transaction - 1, dp);
            int dontSellNow = getMaxProfitMemoization(prices, index + 1, 1, transaction, dp);
            profit = Math.max(canSellNow, dontSellNow);
        }
        dp[index][isBuy][transaction] = profit;
        return profit;
    }


    /**
     * Tabulation
     */
    public int getMaxProfitTabulation(int[] prices, int transactions) {
        int[][][] dp = new int[prices.length + 1][2][transactions + 1];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                for (int transaction = 1; transaction <= transactions; transaction++) {
                    int profit = 0;
                    if (isBuy == 0) {
                        int canBuyNow = -prices[index] + dp[index + 1][1][transaction];
                        int dontBuyNow = dp[index + 1][0][transaction];
                        profit = Math.max(canBuyNow, dontBuyNow);
                    } else {
                        int canSellNow = prices[index] + dp[index + 1][0][transaction - 1];
                        int dontSellNow = dp[index + 1][1][transaction];
                        profit = Math.max(canSellNow, dontSellNow);
                    }
                    dp[index][isBuy][transaction] = profit;
                }
            }
        }
        return dp[0][0][transactions];
    }

    public static void main(String[] args) {

    }
}
