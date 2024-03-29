package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Q10_Merge_Intervals {


    public int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, (inter1, inter2) -> inter1[0] - inter2[0]);

        Stack<int[]> stack = new Stack<>();
        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {

                int[] top = stack.peek();
                if (top[1] < interval[0]) {
                    stack.push(interval);
                } else {
                    stack.pop();
                    stack.push(new int[]{top[0], interval[1]});
                }
            }
        }
        int[][] result = new int[stack.size()][2];
        int index = result.length - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
