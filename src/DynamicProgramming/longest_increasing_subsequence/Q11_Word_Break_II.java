package DynamicProgramming.longest_increasing_subsequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break-ii/description/
public class Q11_Word_Break_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(wordDict);

        List<String> result = new ArrayList<>();
        List<String> combinations = new ArrayList<>();

        backtrack(s, 0, combinations, result, dictionary);
        return result;
    }

    private void backtrack(String str, int index, List<String> combinations,
            List<String> result, Set<String> dictionary) {

        if (index == str.length()) {
            String toAdd = String.join(" ", combinations);
            result.add(toAdd);
        }

        for (int i = index + 1; i <= str.length(); i++) {
            String substring = str.substring(index, i);
            if (dictionary.contains(substring)) {
                combinations.add(substring);
                backtrack(str, i, combinations, result, dictionary);
                combinations.remove(combinations.size() - 1);
            }
        }
    }

}
