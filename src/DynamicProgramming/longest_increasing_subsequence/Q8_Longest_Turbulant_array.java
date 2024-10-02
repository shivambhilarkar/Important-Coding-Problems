package DynamicProgramming.longest_increasing_subsequence;

import java.util.Arrays;

//longest increasing-decreasing subarray
// https://leetcode.com/problems/longest-turbulent-subarray/description/
class Q8_Longest_Turbulan_array {
      public int maxTurbulenceSize(int[] arr) {
            if (arr == null || arr.length == 0) return 0;


            int[] increasing = new int[arr.length];
            int[] decreasing = new int[arr.length];

            Arrays.fill(increasing, 1);
            Arrays.fill(decreasing, 1);

            int result = 1;
            for (int i = 1; i < arr.length; i++) {
                  if (arr[i] > arr[i - 1]) {
                        increasing[i] = decreasing[i - 1] + 1;
                  } else if (arr[i] < arr[i - 1]) {
                        decreasing[i] = increasing[i - 1] + 1;
                  }
                  result = Math.max(result, Math.max(increasing[i], decreasing[i]));
            }
            return result;
      }
}