package Blind75.array;

import java.util.HashSet;
import java.util.Set;


//https://leetcode.com/problems/contains-duplicate/description/
public class Q2_Contains_Duplicate {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return nums.length != set.size();

        }
    }
}
