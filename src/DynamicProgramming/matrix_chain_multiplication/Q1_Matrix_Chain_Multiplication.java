package DynamicProgramming.matrix_chain_multiplication;


import java.io.*;
import java.util.*;


//https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
public class Q1_Matrix_Chain_Multiplication {

      public int recursive(int[] arr, int i, int j) {
            if (i >= j) {
                  return 0;
            }

            int result = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                  int answer = recursive(arr, i, k) + recursive(arr, k + 1, j) +
                          (arr[i - 1] * arr[k] * arr[j]);

                  result = Math.min(result, answer);
            }
            return result;
      }

      public int memoization(int[] arr, int i, int j, int[][] memo) {
            if (i >= j) {
                  return 0;
            }
            if (memo[i][j] != 0) {
                  return memo[i][j];
            }

            int result = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                  int answer = memoization(arr, i, k, memo) + memoization(arr, k + 1, j, memo) +
                          arr[i - 1] * arr[k] * arr[j];

                  result = Math.min(result, answer);

            }
            return memo[i][j] = result;

      }


      public int matrixMultiplication(int N, int arr[]) {
            // int result = recursive(arr , 1, N-1);
            // return result;

            int[][] memo = new int[N][N];
            int result = memoization(arr, 1, N - 1, memo);
            return result;
      }
}
