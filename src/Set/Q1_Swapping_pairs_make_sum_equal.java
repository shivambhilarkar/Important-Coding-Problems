package Set;

import java.util.HashSet;
import java.util.Set;

public class Q1_Swapping_pairs_make_sum_equal {

    public int findPair(long[] array1, long[] array2) {

        Set<Long> set1 = new HashSet<>();
        long sum1 = 0;
        for (long value : array1) {
            sum1 += value;
            set1.add(value);
        }

        long sum2 = 0;
        for (long value : array2) {
            sum2 += value;
        }
        long target = (sum1 - sum2) / 2;
        for (long num : array2) {
            if (set1.contains(num + target)) {
                System.out.print("Pair found");
                return 1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {

    }
}
