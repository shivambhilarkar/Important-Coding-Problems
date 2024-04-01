package Heap_Priority_Queue;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * re-arrange the string such that no adjacent have same characters.
 */
public class Q5_Reorganize_string {

    public String reOrganizeString(String input) {
        if (input == null) return null;

        /*
         * Count Character Frequencies from input string.
         */
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        /*
         * Max Priority Queue.
         */
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        StringBuilder result = new StringBuilder();
        while (queue.isEmpty() == false) {

            Map.Entry<Character, Integer> highest = queue.poll();
            char ch_1 = highest.getKey();

            if (result.length() == 0 || result.charAt(result.length() - 1) == ch_1) {

                result.append(ch_1);
                int value = highest.getValue();
                if (value > 1) {
                    highest.setValue(value - 1);
                    queue.add(highest);
                }
            } else {
                Map.Entry<Character, Integer> secondHighest = queue.poll();
                if (secondHighest == null) return "null";

                result.append(secondHighest.getKey());

                int value = secondHighest.getValue();
                if (value > 1) {
                    secondHighest.setValue(value - 1);
                    queue.add(secondHighest);
                }
                queue.add(highest);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {

    }

}
