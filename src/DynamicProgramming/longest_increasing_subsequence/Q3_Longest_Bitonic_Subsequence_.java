package DynamicProgramming.longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;


//Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic
// if it is first increasing, then decreasing. Write a function that takes an array
// as argument and returns the length of the longest bitonic subsequence.

public class Q3_Longest_Bitonic_Subsequence_ {
      public static int longestIncreasing(int[] arr, int index, int prevElem , int[] dp){
            if(index == arr.length){
                  return 0;
            }
            int take = 0;
            if(arr[index] > prevElem){
                  if(dp[index] == Integer.MIN_VALUE){
                        dp[index] = longestIncreasing (arr, index + 1, arr[index], dp) + 1;
                  }
                  take = dp[index];
            }
            int dontTake = longestIncreasing (arr, index +1, prevElem, dp);
            return Math.max(take , dontTake);
      }
      public static int longestDecreasing(int[] arr, int index, int prevElem, int[] dp){
            if(index == 0){
                  return 0;
            }
            int take = 0;
            if(arr[index] > prevElem){
                  if(dp[index] == Integer.MIN_VALUE){
                        dp[index] = longestDecreasing (arr, index - 1, arr[index], dp) + 1;
                  }
                  take = dp[index];
            }
            int dontTake = longestDecreasing (arr, index - 1, prevElem, dp);
            return Math.max(take, dontTake);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
            int n = arr.length;

            //bitonic = longestIncreasing.. + longestDecreasing.. - 1;
            int[] increasing = new int[n];
            Arrays.fill (increasing, Integer.MIN_VALUE);
            longestIncreasing (arr, 0, Integer.MIN_VALUE, increasing);
            System.out.println(Arrays.toString (increasing));

            int[] decreasing = new int[n];
            Arrays.fill(decreasing, Integer.MIN_VALUE);
            longestDecreasing (arr, n-1, Integer.MIN_VALUE, decreasing);
            System.out.println(Arrays.toString (decreasing));

            int max = 0;
            for(int i = 0; i < n; i++){
                  int curr = increasing[i] + decreasing[i] ;
                  max = Math.max(max, curr);
            }
            System.out.println ("Longest Bitonic Subsequence : "+ max);

      }
}

