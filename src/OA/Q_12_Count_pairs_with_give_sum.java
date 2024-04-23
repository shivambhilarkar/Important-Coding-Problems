package OA;

import java.util.HashMap;
import java.util.Map;

public class Q_12_Count_pairs_with_give_sum {

    public int getPairsCount(int[] arr, int n, int k) {
        // code here

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int pairCount = 0;
        for (int num : arr) {
            int remaining = k - num;
            if (frequencyMap.containsKey(remaining)) {

                pairCount += frequencyMap.get(remaining);

                if (remaining == num) {
                    pairCount -= 1;
                }

            }
        }
        return pairCount / 2;
    }

    public static void main(String[] args) {

    }
}
