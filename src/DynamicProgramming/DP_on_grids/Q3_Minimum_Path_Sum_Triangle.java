package DynamicProgramming.DP_on_grids;

import java.util.List;


//https://leetcode.com/problems/triangle/description/
public class Q3_Minimum_Path_Sum_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[][] dp = new int[n][n];

        //fill last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        //second last row to first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
