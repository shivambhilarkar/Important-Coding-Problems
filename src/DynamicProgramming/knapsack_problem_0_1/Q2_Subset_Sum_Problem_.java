package DynamicProgramming.knapsack_problem_0_1;

import java.util.Scanner;

//iven a set of non-negative integers, and a value sum,
// determine if there is a subset of the given set with sum equal to given sum.
public class Q2_Subset_Sum_Problem_ {
      public static boolean recursive_methode(int[] arr, int sum, int n){
            if(sum == 0){
                  return true;
            }else if(n == 0){
                  return false;
            }

            if(arr[n-1] <= sum){
                  //included or exclude current item
                  return recursive_methode (arr, sum - arr[n-1], n-1) ||
                          recursive_methode (arr, sum, n-1);
            }else {
                  return recursive_methode (arr, sum, n - 1); //not included
            }
      }
      public static boolean memoization_methode(boolean[][] dp ,int[] arr, int sum, int n){
            if(sum == 0){
                  return true;
            }else if(n == 0){
                  return false;
            }

            if(dp[n][sum] != false){
                  return dp[n][sum];
            }
            if(arr[n-1] <= sum){
                  //included or excluded current item
                  dp[n][sum] = ( memoization_methode (dp, arr, sum - arr[n-1], n-1) ||
                                memoization_methode (dp, arr, sum, n-1) );
                  return dp[n][sum];
            }else{
                  //current item excluded
                  dp[n][sum] = memoization_methode (dp, arr, sum, n-1);
                  return dp[n][sum];
            }
      }
      public static boolean top_down_methode(int[] arr, int sum){
            int n = arr.length;
            boolean[][] dp = new boolean[n+1][sum+1];

            for(int i = 0; i < dp.length; i++){
                  for(int j = 0; j < dp[0].length; j++){
                        if(i == 0){
                            dp[i][j] = false;
                        }
                        if(j == 0){
                              dp[i][j] = true;
                        }
                  }
            }

            for(int i = 1; i < dp.length; i++){
                  for(int j = 1; j < dp[0].length; j++){
                        if(arr[i-1] <= j){
                                          //included            //excluded
                              dp[i][j] = ( dp[i-1][j - arr[i-1]] || dp[i-1][j] );
                        }else{
                              //excluded
                              dp[i][j] = dp[i-1][j];
                        }
                  }
            }
            return dp[n][sum];
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
             int[] arr = {3, 34, 4, 12, 5, 2};
             int sum = 9;
            //Output: True
            //There is a subset (4, 5) with sum 9.

            int n = arr.length;
            //recursive methode
            boolean result = recursive_methode (arr, sum, n);
            System.out.println ("Output : "+result);

            //memoization methode
            boolean[][] dp = new boolean[n+1][sum+1];
            boolean result2 = memoization_methode (dp, arr, sum, n);
            System.out.println ("Output : "+result2);

            //top down methode
            boolean result3 = top_down_methode (arr, sum);
            System.out.println("Output : "+result3);
      }
}
