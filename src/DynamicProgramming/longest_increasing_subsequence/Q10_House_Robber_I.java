package DynamicProgramming.longest_increasing_subsequence;

//https://leetcode.com/problems/house-robber/description/
public class Q10_House_Robber_I {

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            int[] include = new int[n];
            int[] exclude = new int[n];

            include[0] = nums[0];
            exclude[0] = 0;

            for (int i = 1; i < n; i++) {
                include[i] = exclude[i - 1] + nums[i];
                exclude[i] = Math.max(include[i - 1], exclude[i - 1]);
            }

            return Math.max(include[n - 1], exclude[n - 1]);
        }
    }

}
