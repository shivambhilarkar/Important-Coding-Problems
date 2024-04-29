package Stack;

import java.util.Arrays;
import java.util.Stack;

//input is circular array.
//https://leetcode.com/problems/next-greater-element-ii/
public class Q013_Next_Greater_Element_II {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int index = 0; index < 2 * n; index++) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[index % n]) {
                int i = stack.pop();
                result[i] = nums[index % n];
            }
            stack.push(index % n);
        }
        return result;
    }
}
