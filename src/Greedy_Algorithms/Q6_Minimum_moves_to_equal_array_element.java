package Greedy_Algorithms;


// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
public class Q6_Minimum_moves_to_equal_array_element {

    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int result = 0;
        for (int num : nums) {
            result += (num - min);
        }
        return result;
    }

}
