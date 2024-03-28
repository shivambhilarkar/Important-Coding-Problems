package DynamicProgramming.fibonaci_numbers;

import java.util.Scanner;

//There are n stairs, a person standing at the bottom wants to reach the top.
//The person can climb either 1 stair or 2 stairs at a time.
//Count the number of ways, the person can reach the top (order does matter).

public class Q2_Staircase_count_ways_to_reach_bottom_ {
      static int count = 0;
      public static int recursive(int n, int steps){
            if(steps > n){
                  return 0;
            }
            if(steps == n){
                  count += 1;
            }

            int oneStep = recursive (n, steps + 1);
            int twoStep = recursive (n, steps + 2);
            return oneStep + twoStep;
      }

      public static int memoization(int n, int steps, int[] dp){
            if(steps < 0){
                  return 0;
            }else if(steps == 0){
                  return 1;
            }

            if(dp[steps] != 0){
                  return dp[steps];
            }

            int oneSteps = memoization (n, steps - 1, dp);
            int twoSteps = memoization (n, steps - 2, dp);

            dp[steps] = oneSteps + twoSteps;
            return dp[steps];

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            System.out.print("Enter Height of Staircase : ");
            int n = scan.nextInt();

            //recursive
            recursive (n, 0);
            System.out.println("Ways : "+count);

            //memoization
            int[] dp = new int[n+1];
            memoization (n, n, dp);
            System.out.println("Ways : "+dp[n]);
      }


}
