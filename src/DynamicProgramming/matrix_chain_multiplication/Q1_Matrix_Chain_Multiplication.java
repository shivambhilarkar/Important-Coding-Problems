package DynamicProgramming.matrix_chain_multiplication;


import java.io.*;
import java.util.*;


//https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
public class Q1_Matrix_Chain_Multiplication {

    //{ Driver Code Starts
//Initial Template for Java


//    class GFG
//    {
//        public static void main(String args[])throws IOException
//        {
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            int t = Integer.parseInt(in.readLine());
//            while(t-- > 0){
//                int N = Integer.parseInt(in.readLine());
//                String input_line[] = in.readLine().trim().split("\\s+");
//                int arr[]= new int[N];
//                for(int i = 0; i < N; i++)
//                    arr[i] = Integer.parseInt(input_line[i]);
//
//                Solution ob = new Solution();
//                System.out.println(ob.matrixMultiplication(N, arr));
//            }
//        }
//    }

// } Driver Code Ends


//User function Template for Java

    public int recursive(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int answer = recursive(arr, i, k) +
                    recursive(arr, k + 1, j) +
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
            int answer = memoization(arr, i, k, memo) +
                    memoization(arr, k + 1, j, memo) +
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
