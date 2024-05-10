package Blind75.array;

//https://leetcode.com/problems/maximum-subarray/description/
public class Q3_Max_Sum_Subarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > 0) {
                    nums[i] += nums[i - 1];
                }
                result = Math.max(result, nums[i]);
            }

            return result;
        }
    }
}
