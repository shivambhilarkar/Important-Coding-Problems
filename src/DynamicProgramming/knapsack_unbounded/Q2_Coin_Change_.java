package DynamicProgramming.knapsack_unbounded;

import java.util.Scanner;

//coin change I : maximum no of ways.
public class Q2_Coin_Change_ {
      public static int recursive_methode(int[] coin, int sum, int n){
            if(sum == 0){
                  return 1;
            }else if(n == 0){
                  return 0;
            }

            if(coin[n-1] <= sum){
                  return recursive_methode (coin, sum - coin[n-1], n) //include.
                          + recursive_methode (coin, sum , n-1); //exclude.
            }else{
                  return recursive_methode (coin, sum, n-1); //exclude.
            }
      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] coin = { 1, 2 ,3};
            int sum = 5;
            //recursive methode.
            int result = recursive_methode (coin, sum, coin.length);
            System.out.println("Output : "+result);

      }
}
