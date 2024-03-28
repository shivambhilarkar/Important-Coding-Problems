package DynamicProgramming.knapsack_problem_0_1;

import java.util.Scanner;

//Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
// In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
// Also given an integer W which represents knapsack capacity,
// find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
// You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
public class Q1_0_1_KnapSack_Problem_ {
      public static int recursive_methode(int[] val, int[] weight, int capacity ,int n){
            if(capacity == 0 || n == 0){
                  return 0;
            }
            if(weight[n-1] <= capacity){
                  //we have to choices include or exclude & max of both choices
                  return Math.max( val[n-1] + recursive_methode (val, weight, capacity - weight[n-1], n-1) ,
                          recursive_methode (val, weight, capacity, n-1));
            }else{ //exclude the current item
                  return recursive_methode (val, weight, capacity, n-1);
            }
      }
      public static int memoization_methode(int[][] dp , int[] val, int[] weight, int capacity, int n){
            if(capacity == 0 || n == 0){
                  return 0;
            }
            if(dp[n][capacity] != 0){ //if dp contains result already then return it from there.
                  return dp[n][capacity];
            }
            if(weight[n-1] <= capacity){
                  //both choices include or exclude..
                 dp[n][capacity] = Math.max(val[n-1] + memoization_methode (dp, val, weight, capacity-weight[n-1], n-1),
                              memoization_methode (dp, val, weight, capacity, n-1) );
                 return dp[n][capacity]; //max from both choices
            }else{
                  dp[n][capacity] =  memoization_methode (dp, val, weight, capacity, n-1); //exclude the current item
                  return dp[n][capacity];
            }
      }
      public static int top_down_methode(int[] val, int[] weight, int capacity){
            int n = val.length;
            int[][] dp = new int[n+1][capacity+1];

            //i -> number of item   j -> capacity till jth
            for(int i = 0; i < dp.length; i++){
                  for(int j = 0; j < dp[0].length; j++){
                        if(i == 0 || j == 0){
                              dp[i][j] = 0;
                              continue;
                        }
                        //current weight <  ( capacity == j)
                        if(weight[i-1] <= j){
                             dp[i][j] = Math.max( val[i-1] + dp[i-1][j - weight[i-1]],  //not included
                                                             dp[i-1][j]);                  //included
                        }else {
                              dp[i][j] = dp[i-1][j]; //not included
                        }
                  }
            }
            return dp[n][capacity];
      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int val[] = new int[] { 60, 100, 120 };
            int wt[] = new int[] { 10, 20, 30 };
            int W = 50; //knapsack capacity

//            output : 220
            int n = val.length;
            int result = recursive_methode (val, wt, W, n);
            System.out.println("Output : "+result);

//          Memoization Methode..
            int[][] dp = new int[n + 1][W + 1];  //number of element & maximum capacity;
            int result2 = memoization_methode (dp , val, wt, W, n);
            System.out.println("Output : "+result2);

//            top down methode
            int result3 = top_down_methode (val, wt, W);
            System.out.println("Output : "+result3);

      }
}
