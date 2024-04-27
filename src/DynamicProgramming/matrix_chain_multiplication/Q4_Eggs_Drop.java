package DynamicProgramming.matrix_chain_multiplication;


//https://leetcode.com/problems/super-egg-drop/
public class Q4_Eggs_Drop {


    // recursive
    public int recursive(int eggs, int floor) {
        if (floor <= 1) return floor;
        if (eggs == 1) return floor;

        int min = floor;
        for (int k = 1; k <= floor; k++) {
            int left = recursive(eggs - 1, k - 1);
            int right = recursive(eggs, floor - k);

            min = Math.min(min, Math.max(left, right) + 1);
        }
        return min;
    }


    //memoization
    public int memoization(int eggs, int floor, int[][] memo) {
        if (eggs == 1 || floor <= 1) {
            return floor;
        }

        if (memo[eggs][floor] != 0) {
            return memo[eggs][floor];
        }

        int result = floor;
        for (int k = 1; k <= floor; k++) {
            int low = 0;
            int high = 0;

            if (memo[eggs - 1][k - 1] > 0) {
                low = memo[eggs - 1][k - 1];
            } else {
                low = memoization(eggs - 1, k - 1, memo);
            }

            if (memo[eggs][floor - k] > 0) {
                high = memo[eggs][floor - k];
            } else {
                high = memoization(eggs, floor - k, memo);
            }


            result = Math.min(result, Math.max(low, high) + 1);
        }
        memo[eggs][floor] = result;
        return result;
    }


    public int superEggDrop(int k, int n) {
        // return recursive(k, n);

        int[][] memo = new int[k + 1][n + 1];

        return memoization(k, n, memo);
    }

}
