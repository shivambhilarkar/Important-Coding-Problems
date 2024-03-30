package DynamicProgramming.DP_on_stocks;

import java.util.Arrays;

public class Q2_Buy_and_sell_II {

    /**
     * 0 -> buy
     * 1 -> sell
     * @param stocks
     * @return max profit after unlimited transactions.
     */


    /**
     * Recursion
     */

    public static int getMaximumProfitRecursive(int[] input) {
        return getMaximumProfitRecursive(input, 0, 0);
    }

    //if buying now the need to sell in next move, hence we do negation of current choice in next move.
    //if currently buy == true then in next move you can't buy again you can only sell.
    //if currently sell == true then in next move you can't sell again you need to buy first then you can sell again.
    private static int getMaximumProfitRecursive(int[] input, int index, int isBuy) {
        if (index == input.length) return 0;

        int profit = 0;

        if (isBuy == 0) {
            int canBuyNow = -input[index] + getMaximumProfitRecursive(input, index + 1, 1);
            int dontBuyNow = getMaximumProfitRecursive(input, index + 1, 0);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = input[index] + getMaximumProfitRecursive(input, index + 1, 0);
            int dontSellNow = getMaximumProfitRecursive(input, index + 1, 1);
            profit = Math.max(canSellNow, dontSellNow);
        }

        return profit;
    }


    /**
     * Memoization
     */

    public static int getMaximumProfitMemoization(int[] input) {
        int[][] dp = new int[input.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaximumProfitMemoization(input, 0, 0, dp);
    }

    private static int getMaximumProfitMemoization(int[] input, int index, int isBuy, int[][] dp) {
        if (index == input.length) return 0;

        if (dp[index][isBuy] != -1) {
            return dp[index][isBuy];
        }
        int profit = 0;

        if (isBuy == 0) {
            int canBuyNow = -input[index] + getMaximumProfitMemoization(input, index + 1, 1, dp);
            int dontBuyNow = getMaximumProfitMemoization(input, index + 1, 0, dp);
            profit = Math.max(canBuyNow, dontBuyNow);
        } else {
            int canSellNow = input[index] + getMaximumProfitMemoization(input, index + 1, 0, dp);
            int dontSellNow = getMaximumProfitMemoization(input, index + 1, 1, dp);
            profit = Math.max(canSellNow, dontSellNow);
        }

        dp[index][isBuy] = profit;
        return profit;
    }


    /**
     * Tabulation
     */
    //tabulation method
    public static int getMaximumProfitTabulation(int[] input) {
        if (input == null || input.length == 0) return 0;

        int n = input.length;
        int[][] dp = new int[2][input.length + 1];
        for (int index = input.length - 1; index >= 0; index--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                int profit = 0;

                if (isBuy == 0) {
                    int canBuy = -input[index] + dp[1][index + 1];
                    int dontBuy = dp[0][index + 1];
                    profit = Math.max(canBuy, dontBuy);
                } else {
                    int canSell = input[index] + dp[0][index + 1];
                    int dontSell = dp[1][index + 1];
                    profit = Math.max(canSell, dontSell);
                }

                dp[isBuy][index] = profit;
            }
        }
        return dp[0][0];

    }


    public static void main(String[] args) {

        /**
         * Input: prices = [7,1,5,3,6,4]
         * Output: 7
         */

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = getMaximumProfitRecursive(prices);
        System.out.println(result);
    }

}
