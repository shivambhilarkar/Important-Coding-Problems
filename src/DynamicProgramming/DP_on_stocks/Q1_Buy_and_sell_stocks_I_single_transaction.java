package DynamicProgramming.DP_on_stocks;

public class Q1_Buy_and_sell_I {


    public static int getMaximumProfit(int[] stocks){
        if(stocks == null || stocks.length == 0) return 0;

        int lowestStock = stocks[0];
        int maxProfit = lowestStock;

        for(int i = 1; i < stocks.length; i++){
            int currentProfit = stocks[i] - lowestStock;

            maxProfit = Math.max(maxProfit, currentProfit);
            lowestStock = Math.min(lowestStock, stocks[i]);
        }
        return maxProfit;
    }


    public static void main(String[] args) {

    }
}
