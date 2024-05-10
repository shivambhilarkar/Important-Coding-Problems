package Blind75.heap;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class Q1_Top_K_Element {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            queue.addAll(map.entrySet());

            int index = 0;
            int[] result = new int[k];
            while (queue.isEmpty() == false && k-- > 0) {
                Map.Entry<Integer, Integer> entry = queue.poll();
                result[index] = entry.getKey();
                index += 1;
            }
            return result;
        }
    }
}
