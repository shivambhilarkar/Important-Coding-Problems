package DynamicProgramming.DP_on_grids;

//https://leetcode.com/problems/cherry-pickup/description/
public class Q4_Cherry_Pickup_I {

    public int recursive(int r1, int c1, int r2, int c2, int[][] grid) {
        if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == grid.length - 1 && c1 == grid[0].length - 1 && r2 == grid.length - 1 && c2 == grid[0].length - 1) {
            return grid[r1][c1];
        }


        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int ans1 = recursive(r1 + 1, c1, r2 + 1, c2, grid); //vv
        int ans2 = recursive(r1, c1 + 1, r2, c2 + 1, grid); //hh
        int ans3 = recursive(r1 + 1, c1, r2, c2 + 1, grid); //vh
        int ans4 = recursive(r1, c1 + 1, r2 + 1, c2, grid); //hv

        cherries += Math.max(Math.max(ans1, ans2), Math.max(ans3, ans4));
        return cherries;
    }

    public int memoization(int r1, int c1, int r2, int c2, int[][] grid, int[][][][] dp) {
        if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        //reached on bottom-right-cell
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1 && r2 == grid.length - 1 && c2 == grid[0].length - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != 0) {
            return dp[r1][c1][r2][c2];
        }


        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int ans1 = memoization(r1, c1 + 1, r2, c2 + 1, grid, dp);   //hh
        int ans2 = memoization(r1 + 1, c1, r2 + 1, c2, grid, dp);   //vv
        int ans3 = memoization(r1, c1 + 1, r2 + 1, c2, grid, dp);   //hv
        int ans4 = memoization(r1 + 1, c1, r2, c2 + 1, grid, dp);   //vh

        cherries += Math.max(Math.max(ans1, ans2), Math.max(ans3, ans4));
        return dp[r1][c1][r2][c2] = cherries;
    }


    public int cherryPickup(int[][] grid) {
        // int result = recursive(0 ,0 ,0, 0, grid);
        // return Math.max(result, 0);

        int r = grid.length;
        int c = grid[0].length;

        int[][][][] dp = new int[r][c][r][c];

        int result = memoization(0, 0, 0, 0, grid, dp);
        return Math.max(result, 0);
    }


}
