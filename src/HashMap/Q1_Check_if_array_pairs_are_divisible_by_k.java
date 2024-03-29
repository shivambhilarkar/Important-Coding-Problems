package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Q1_Check_if_array_pairs_are_divisible_by_k {


    private boolean canArrange(int[] array, int k) {
        if (array == null || array.length == 0) {
            return false;
        }

        Map<Integer, Integer> remainderMap = new HashMap<>();
        for (int num : array) {
            int remainder = ((num % k) + k) % k;
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }

        for (int value : array) {

            int remainder = ((value % k) + k) % k;

            if (remainder == 0 || 2 * remainder == k) {
                if (remainderMap.get(remainder) % 2 == 1) {
                    return false;
                } else {
                    int freq = remainderMap.get(remainder);
                    int ofq = remainderMap.getOrDefault(k - remainder, 0);
                    if (freq != ofq) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
