package DynamicProgramming.DP_on_stocks;

import java.util.Arrays;

public class Q6_Buy_and_sell_stocks_VI_with_transaction_fee {

    /**
     * Recursive
     */
    public int getMaxProfitRecursive(int[] prices, int fee) {
        return getMaxProfitRecursive(prices, 0, 0, fee);
    }

    private int getMaxProfitRecursive(int[] prices, int index, int isBuy, int fee) {
        if (index == prices.length) return 0;

        int profit = 0;
        if (isBuy == 0) {
            int canBuyNow = -prices[index] + (-fee) + getMaxProfitRecursive(prices, index + 1, 1, fee);
            int dontBuyNow = getMaxProfitRecursive(prices, index + 1, 0, fee);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = prices[index] + getMaxProfitRecursive(prices, index + 1, 0, fee);
            int dontSellNow = getMaxProfitRecursive(prices, index + 1, 1, fee);
            profit = Math.max(canSellNow, dontSellNow);
        }
        return profit;
    }

    /**
     * Memoization
     */
    public int getMaxProfitMemoization(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaxProfitMemoization(prices, 0, 0, fee, dp);
    }

    private int getMaxProfitMemoization(int[] prices, int index, int isBuy, int fee, int[][] dp) {
        if (index == prices.length) return 0;

        if (dp[index][isBuy] != -1) {
            return dp[index][isBuy];
        }

        int profit = 0;
        if (isBuy == 0) {
            int canBuyNow = -prices[index] + (-fee) + getMaxProfitMemoization(prices, index + 1, 1, fee, dp);
            int dontBuyNow = getMaxProfitMemoization(prices, index + 1, 0, fee, dp);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = prices[index] + getMaxProfitMemoization(prices, index + 1, 0, fee, dp);
            int dontSellNow = getMaxProfitMemoization(prices, index + 1, 1, fee, dp);
            profit = Math.max(canSellNow, dontSellNow);
        }
        dp[index][isBuy] = profit;
        return profit;
    }

    public static void main(String[] args) {

    }
}
