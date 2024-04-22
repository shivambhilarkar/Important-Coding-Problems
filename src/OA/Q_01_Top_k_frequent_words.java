package OA;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order.
 */


public class Q_01_Top_k_frequent_words {

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) return new ArrayList<>();


        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) ->
                b.getValue() == a.getValue() ? (a.getKey()).compareTo(b.getKey()) : b.getValue() - a.getValue());

        queue.addAll(frequencyMap.entrySet());

        List<String> result = new ArrayList<>();
        while (k > 0 && !queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            result.add(entry.getKey());
            k -= 1;
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
