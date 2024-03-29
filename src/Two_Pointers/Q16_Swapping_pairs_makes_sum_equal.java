package Two_Pointers;

import java.util.Arrays;

public class Q16_Swapping_pairs_makes_sum_equal {

    public long findSwapValue(long[] arr1, int n, long[] arr2, int m) {

        long sum1 = getSum(arr1);
        long sum2 = getSum(arr2);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        while (i < n && j < m) {

            long first = (sum1 - arr1[i]) + arr2[j];
            long second = (sum2 - arr2[j]) + arr1[i];

            if (first == second) {
                //pair found
                return 1;
            } else if (first > second) {
                i += 1;
            } else {
                j += 1;
            }

        }
        //not found
        return -1;
    }

    private long getSum(long[] array) {
        long sum = 0;
        for (long num : array) {
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {

    }

}
