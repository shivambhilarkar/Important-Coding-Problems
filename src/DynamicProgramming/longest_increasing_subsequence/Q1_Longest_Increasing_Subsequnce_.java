package DynamicProgramming.longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_Longest_Increasing_Subsequnce_ {
      public static int recursive(int[] arr , int index, int prevEle){
            if(index >= arr.length){
                  return 0;
            }

            int take = 0;
            if(arr[index] > prevEle){
                  take = recursive (arr, index + 1, arr[index]) + 1;
            }
            int dontTake = recursive (arr, index + 1, prevEle);
            return Math.max(take, dontTake);
      }

      public static int memoization(int[] nums, int index, int prevEle, int[] dp){
            if(index >= nums.length){
                  return 0;
            }

            int take = 0;

            if(nums[index] > prevEle){
                  if(dp[index] == Integer.MIN_VALUE){
                        dp[index] = 1 + memoization(nums, index + 1, nums[index], dp);
                  }
                  take = dp[index];
            }
             int dontTake = memoization(nums, index + 1, prevEle, dp);
            return Math.max(take, dontTake);
      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] arr = {10,9,2,5,3,7,101,18};
            int n = arr.length;
            //The longest increasing subsequence is [2,3,7,101], therefore the length is 4
            //recursive methode
            //prevEelement = minimum element;
            int result = recursive (arr, 0 , Integer.MIN_VALUE);
            System.out.println("LIS : "+result);

            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MIN_VALUE);
            int result2 = memoization (arr, 0 , Integer.MIN_VALUE, dp);
            System.out.println("LIS : "+ result2);
      }

}
