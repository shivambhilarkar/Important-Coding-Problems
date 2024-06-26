package Blind75.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
public class Q1_Two_Sum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
