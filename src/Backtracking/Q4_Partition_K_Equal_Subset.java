package Backtracking;

import java.util.Arrays;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
public class Q4_Partition_K_Equal_Subset {

      public boolean canPartitionKSubsets(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                  return true;
            }

            int total = 0;
            for (int num : nums) {
                  total += num;
            }

            if (total % k != 0) return false;

            int n = nums.length;
            Arrays.sort(nums);
            int target = total / k;
            boolean[] visited = new boolean[n];
            return backtrack(nums, target, n - 1, visited, 0, k);
      }

      private boolean backtrack(int[] nums, int target, int start, boolean[] visited, int sum, int round) {
            if (round == 0) {
                  return true;
            }

            if (sum == target && backtrack(nums, target, nums.length - 1, visited, 0, round - 1)) {
                  return true;
            }


            for (int i = start; i >= 0; i--) {
                  if (visited[i] == false && sum + nums[i] <= target) {
                        visited[i] = true;
                        if (backtrack(nums, target, i - 1, visited, sum + nums[i], round)) {
                              return true;
                        }
                        visited[i] = false;
                  }
            }
            return false;
      }
}
