package DynamicProgramming.DP_on_grids;

import java.util.Arrays;

//https://leetcode.com/problems/cherry-pickup-ii/description/
public class Q4_Cherry_Pickup_II {


    public int recursive(int i, int j1, int j2, int[][] grid) {
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return 0;
        }

        // present on last row
        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        int max = 0;
        // apply directions to both robots
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value += grid[i][j1] + recursive(i + 1, j1 + dj1, j2 + dj2, grid);
                } else {
                    value += grid[i][j1] + grid[i][j2] + recursive(i + 1, j1 + dj1, j2 + dj2, grid);
                }
                max = Math.max(max, value);
            }
        }
        return max;
    }

    public int memoization(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return 0;
        }

        // present on last row
        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }


        int max = 0;
        // apply directions to both robots
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value += grid[i][j1] + memoization(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                } else {
                    value += grid[i][j1] + grid[i][j2] + memoization(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                }
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;

    }

    public int cherryPickup(int[][] grid) {

        int cols = grid[0].length;
        int robot1 = 0;
        int robot2 = cols - 1;
        int row = 0;

        // return recursive(row, robot1, robot2, grid);

        int[][][] dp = new int[grid.length][cols][cols];
        //fill dp with -1
        for (int[][] matrix : dp) {
            for (int[] r : matrix) {
                Arrays.fill(r, -1);
            }
        }

        return memoization(row, robot1, robot2, grid, dp);
    }

}
