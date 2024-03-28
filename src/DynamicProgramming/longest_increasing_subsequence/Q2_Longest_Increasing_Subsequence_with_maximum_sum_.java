package DynamicProgramming.longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_Longest_Increasing_Subsequence_with_maximum_sum_ {
      public static int recursive(int[] nums, int index, int prevElem){
            if(index >= nums.length){
                  return 0;
            }
            int take = 0;
            if(nums[index] > prevElem){
                  take = recursive (nums, index + 1, nums[index]) + nums[index];
            }
            int dontTake = recursive (nums, index+1, prevElem);
            return Math.max(take, dontTake);
      }

      public static int memoization(int[] nums, int index, int prevElem, int[] dp){
            if(index == nums.length){
                  return 0;
            }
            int take = 0;
            if(nums[index] > prevElem){
                  if(dp[index] == Integer.MIN_VALUE){
                     dp[index] = memoization (nums, index, nums[index ],dp) + nums[index];
                  }
                  take = dp[index];
            }
            int dontTake = memoization (nums, index + 1, prevElem, dp);
            return Math.max(take, dontTake);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] nums = {1, 101, 2, 3, 100};
            // 1 -> 2 -> 3 -> 100 = 106
            int n = nums.length;

            //recursive approach
            int result = recursive (nums, 0, Integer.MIN_VALUE);
            System.out.println("LIS sum : " +result);

            //memoization approach
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            int result2 = memoization (nums, 0, Integer.MIN_VALUE, dp);
            System.out.println("LIS sum : "+result2);


      }
}
