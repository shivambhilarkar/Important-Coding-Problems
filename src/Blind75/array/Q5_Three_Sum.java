package Blind75.array;

import java.util.*;

public class Q5_Three_Sum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null) {
                return new ArrayList<>();
            }

            Set<List<Integer>> set = new HashSet<>();

            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int value = nums[start] + nums[end] + nums[i];
                    if (value == 0) {
                        set.add(Arrays.asList(nums[start], nums[end], nums[i]));
                        start += 1;
                        end -= 1;
                    } else if (value < 0) {
                        start += 1;
                    } else {
                        end -= 1;
                    }
                }
            }

            List<List<Integer>> result = new ArrayList<>();
            result.addAll(set);
            return result;
        }
    }
}
