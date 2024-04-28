package Sliding_Window;

import java.util.PriorityQueue;


// https://leetcode.com/problems/sliding-window-maximum/
public class Q07_Sliding_Window_Maximum {


    /**
     * Brute Force Approach using PriorityQueue
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] { 0 };
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        int index = 0;
        int[] result = new int[nums.length - k + 1];

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            queue.add(nums[right]);

            if (right >= k - 1) {
                int max = queue.peek();
                result[index++] = max;

                queue.remove(nums[left]);
                left += 1;
            }
        }
        return result;
    }

}
