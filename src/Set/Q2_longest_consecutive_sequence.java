package Set;

import java.util.HashSet;
import java.util.Set;

public class Q2_longest_consecutive_sequence {

    public int longestConsecutiveSequence(int[] input) {
        if (input == null || input.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : input) set.add(num);

        int result = 0;
        for (int num : input) {
            if (!set.contains(num - 1)) {
                int startValue = num;
                int count = 0;
                while (set.contains(startValue + 1)) {
                    startValue += 1;
                    count += 1;
                }
                result = Math.max(count, result);
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
