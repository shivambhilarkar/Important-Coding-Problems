package DynamicProgramming.knapsack_problem_0_1;

import java.util.Scanner;

//Given an array arr[] of length N and an integer X,
// the task is to find the number of subsets with a sum equal to X.
public class Q4_Subset_Sum_Count_Problem_ {
      public static int recursive_methode(int[] arr, int sum, int n){
            if(sum == 0){
                  return 1;
            }else if(n == 0){
                  return 0;
            }
            if(arr[n-1] <= sum){
                                                //if we take current item.
                  return recursive_methode (arr, sum - arr[n-1], n-1) +
                          recursive_methode (arr, sum, n-1); //if we exclude current item.
            }else{
                  //exclude
                  return recursive_methode (arr, sum, n-1);
            }
      }
      public static int memoization_methode(int[][] dp, int[] arr, int sum, int n){
            if(sum == 0){ return 1; }
            else if(n == 0) { return 0; }

            if(dp[n][sum] != 0){
                  return dp[n][sum];
            }
            if(arr[n-1] <= sum){
                  dp[n][sum] =  memoization_methode (dp, arr, sum - arr[n-1], n-1) + //include
                                memoization_methode (dp, arr, sum, n-1); //exclude
                  return dp[n][sum];
            }else{
                  dp[n][sum] =  memoization_methode (dp, arr, sum, n-1); //exclude
                  return dp[n][sum];
            }
      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] arr = {1, 2, 3, 3};
            int X = 6;
//            Output: 3
//            All the possible subsets are {1, 2, 3}, {1, 2, 3} and {3, 3}
            int n = arr.length;
            //recursive methode
            int result = recursive_methode (arr, X, n);
            System.out.println("Output : "+result);

            //memoization
            int[][] dp = new int[n+1][X+1];
            int result2 = memoization_methode(dp, arr, X, n);
            System.out.println("Output : "+result2);
      }
}
