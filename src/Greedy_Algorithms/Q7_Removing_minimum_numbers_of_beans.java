package Greedy_Algorithms;

import java.util.Arrays;

//https://leetcode.com/problems/removing-minimum-number-of-magic-beans/description/
public class Q7_Removing_minimum_numbers_of_beans {

    public long minimumRemoval(int[] beans) {
        if (beans == null || beans.length == 0) {
            return 0;
        }

        long sum = 0;
        for (long num : beans) {
            sum += num;
        }

        Arrays.sort(beans);

        long n = beans.length;
        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            result = Math.min(result, sum - (n - i) * beans[i]);
        }
        return result;
    }
}
