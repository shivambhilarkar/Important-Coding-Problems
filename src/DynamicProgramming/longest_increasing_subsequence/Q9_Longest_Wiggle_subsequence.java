package DynamicProgramming.longest_increasing_subsequence;


//longest increasing-decreasing subsequence
// https://leetcode.com/problems/wiggle-subsequence/description/

class Q9_Longest_Wiggle_subsequence {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] increasing = new int[nums.length];
            int[] decreasing = new int[nums.length];

            increasing[0] = decreasing[0] = 1;

            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    increasing[i] = decreasing[i - 1] + 1;
                    decreasing[i] = decreasing[i - 1];
                } else if (nums[i] < nums[i - 1]) {
                    decreasing[i] = increasing[i - 1] + 1;
                    increasing[i] = increasing[i - 1];
                } else {
                    increasing[i] = increasing[i - 1];
                    decreasing[i] = decreasing[i - 1];
                }
            }
            return Math.max(increasing[n - 1], decreasing[n - 1]);
        }
    }
}