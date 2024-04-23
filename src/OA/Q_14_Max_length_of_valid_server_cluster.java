package OA;

import java.util.PriorityQueue;


// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class Q_14_Max_length_of_valid_server_cluster {


    public int longestSubarray(int[] nums, int limit) {

        int start = 0;
        int end = 0;
        int result = 1;

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);

        while (start <= end && end < nums.length) {
            minQ.add(nums[end]);
            maxQ.add(nums[end]);

            int minNum = minQ.peek();
            int maxNum = maxQ.peek();

            if (maxNum - minNum <= limit) {
                end += 1;
                result = Math.max(result, end - start);
            } else {
                minQ.remove(nums[start]);
                maxQ.remove(nums[start]);
                start += 1;
                end += 1;
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
