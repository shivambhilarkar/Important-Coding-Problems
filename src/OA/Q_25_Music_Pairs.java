package OA;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
public class Q_25_Music_Pairs {

    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }

        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : time) {
            int rem = num % 60;

            count += freqMap.getOrDefault((60 - rem) % 60, 0);

            freqMap.put(rem, freqMap.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
