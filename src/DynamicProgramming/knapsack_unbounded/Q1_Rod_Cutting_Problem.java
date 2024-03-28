package DynamicProgramming.knapsack_unbounded;

import java.util.Scanner;

//Given a rod of length n inches and an array of prices
// that includes prices of all pieces of size smaller than n.
// Determine the maximum value obtainable by cutting up the rod and selling the pieces.
public class Q1_Rod_Cutting_Problem {
      public static int recursive_methode(int[] len, int[] price, int rodlen,int n){
            if(n == 0 || rodlen == 0){
                  return 0;
            }

            if(len[n-1] <= rodlen){
                  return Math.max ( price[n-1] + recursive_methode (len, price, rodlen - len[n-1], n) ,
                                                recursive_methode (len, price, rodlen, n-1));
            }else{
                  return recursive_methode (len, price, rodlen, n-1); //excluded
            }
      }
      public static int top_down_methode(int[] len, int[] price, int rodlen){
            int n = price.length ;
            int[][] dp = new int[n + 1][rodlen + 1];
            for(int i = 0; i < dp.length; i++){
                  for(int j = 0; j < dp[0].length; j++){
                        if(i == 0 || j == 0){
                              dp[i][j] = 0;
                              continue;
                        }

                        if(len[i-1] <= j){
                              dp[i][j] =  Math.max( price[i-1] + dp[i][j - len[i-1]]  , dp[i-1][j]);
                        }else{
                              dp[i][j] = dp[i-1][j];
                        }
                  }
            }
            return dp[n][rodlen];
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] len = {1,2,3,4,5,6};
            int[] price = {1,5,8,9,10,17};
            int rodlen  = 8;
            //output = 8 + 10 = 18  ; 3len + 5len = 8len ❌
            //output = 5 + 17 = 22  ; 2len + 6len = 8len ✅
            int result = recursive_methode (len, price, rodlen, price.length);
            System.out.println(result);

            //top down methode
            int result2 = top_down_methode (len, price, rodlen);
            System.out.println(result2);
      }
}
