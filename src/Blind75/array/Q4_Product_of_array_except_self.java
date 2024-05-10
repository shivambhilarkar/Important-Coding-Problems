package Blind75.array;


//https://leetcode.com/problems/product-of-array-except-self/description/
public class Q4_Product_of_array_except_self {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return nums;
            }
            int n = nums.length;
            int[] prefix = new int[n];
            prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = prefix[i - 1] * nums[i];
            }


            int[] suffix = new int[n];
            suffix[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i];
            }


            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    result[i] = suffix[i + 1];
                } else if (i == n - 1) {
                    result[i] = prefix[i - 1];
                } else {
                    result[i] = suffix[i + 1] * prefix[i - 1];
                }
            }
            return result;
        }
    }
}
