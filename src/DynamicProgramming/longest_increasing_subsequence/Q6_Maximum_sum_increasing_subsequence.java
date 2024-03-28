package DynamicProgramming.longest_increasing_subsequence;

import java.util.Scanner;

public class Q6_Maximum_sum_increasing_subsequence {

    /**
     * find out maximum sum increasing subsequences
     * sum should be maximum and subsequence should be increasing
     */
    public static int getMaximumIncreasingSubsequence(int[] input){
        if(input == null || input.length == 0) return 0;

        int n = input.length;
        int[] dp = new int[n];

        int maxSubsequence = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int current = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++){
                if(input[j] < input[i]){
                    current = Math.max(current, dp[j]);
                }
            }

            dp[i] = current == Integer.MIN_VALUE ? input[i] : (current + input[i]);

            maxSubsequence = Math.max(dp[i], maxSubsequence);
        }
        return maxSubsequence;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
    }
}
