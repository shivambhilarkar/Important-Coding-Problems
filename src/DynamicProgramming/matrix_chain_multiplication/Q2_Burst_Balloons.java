package DynamicProgramming.matrix_chain_multiplication;


//https://leetcode.com/problems/burst-balloons/
public class Q2_Burst_Balloons {


    /**
     * Recursive
     */
    public int recursive(int[] ballons, int i, int j) {
        if (i > j) {
            return 0;
        }

        int result = 0;
        for (int k = i; k <= j; k++) {
            int answer = recursive(ballons, i, k - 1) + recursive(ballons, k + 1, j) + (ballons[i - 1] * ballons[k] * ballons[j + 1]);

            result = Math.max(answer, result);
        }
        return result;
    }

    /**
     * Memoization
     */
    public int memoization(int[] ballons, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int result = 0;
        for (int k = i; k <= j; k++) {
            int answer = memoization(ballons, i, k - 1, memo) + memoization(ballons, k + 1, j, memo) + ballons[i - 1] * ballons[k] * ballons[j + 1];

            result = Math.max(answer, result);
        }
        memo[i][j] = result;
        return result;
    }


    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] ballons = new int[nums.length + 2];
        ballons[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            ballons[i] = nums[i - 1];
        }
        ballons[ballons.length - 1] = 1;


        // int result = recursive(ballons, 1, nums.length);
        // return result;

        int[][] memo = new int[ballons.length][ballons.length];
        int result = memoization(ballons, 1, nums.length, memo);
        return result;
    }
}
