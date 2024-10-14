package Sliding_Window;

import java.util.ArrayDeque;
import java.util.PriorityQueue;


// https://leetcode.com/problems/sliding-window-maximum/
public class Q07_Sliding_Window_Maximum {


    /**
     * Brute Force Approach using PriorityQueue
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{0};
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

//=========================== optimise solution

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) return new int[]{};

            final ArrayDeque<Integer> indexQueue = new ArrayDeque<>();
            final int[] result = new int[nums.length - k + 1];
            int rIndex = 0;

            for (int index = 0; index < nums.length; index++) {
                int currentElement = nums[index];

                //remove out of bound elements.
                if (!indexQueue.isEmpty() && indexQueue.peekFirst() <= index - k) {
                    indexQueue.removeFirst();
                }

                //maintain montonic queue property
                while (!indexQueue.isEmpty() && nums[indexQueue.peekLast()] <= currentElement) {
                    indexQueue.removeLast();
                }
                //add index to queue
                indexQueue.add(index);

                if (index >= k - 1) {
                    result[rIndex] = nums[indexQueue.peekFirst()];
                    rIndex += 1;
                }
            }

            return result;
        }
    }

}
