package DynamicProgramming.DP_on_stocks;

public class Q2_Buy_and_sell_II {

    public int memoizationBuyAndSell(int[] stocks) {
        return dfs(stocks, 0, true, new int[][]{});
    }

    private int dfs(int[] stocks, int index, boolean isBuy, int[][] dp) {
        if (index == stocks.length) return 0;

        if(isBuy){
            if((dp[index][0]) != 0){
                return dp[index][0];
            }
        }else{
            if((dp[index][1] != 0)){
                return dp[index][1];
            }
        }

        int profit = 0;
        if (isBuy) {
            profit = Math.max(-stocks[index] + dfs(stocks, index + 1, true, dp),
                    dfs(stocks, index + 1, false, dp));
        } else {
            profit = Math.max(stocks[index] + dfs(stocks, index + 1, true, dp),
                    dfs(stocks, index + 1, false, dp));
        }

        if(isBuy){
            dp[index][0] = profit;
        }else{
            dp[index][1] = profit;
        }
        return profit;


    }


    public static void main(String[] args) {

    }

}
