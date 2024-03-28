package DynamicProgramming.longest_increasing_subsequence;

import java.util.HashSet;
import java.util.Set;

public class Q7_Longest_consecutive_subsequence {

    /**
     * find out longest consecutive subsequence
     * consecutive -> one after another without missing number
     * @param nums
     * @return
     */

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int startValue = num;
                while (set.contains(startValue + 1)) {
                    count += 1;
                    startValue = startValue + 1;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;


    }

    public static void main(String[] args) {

    }

}
