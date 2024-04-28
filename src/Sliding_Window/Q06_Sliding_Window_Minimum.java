package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class Q06_Sliding_Window_Minimum {
    
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int wordCount = map.size();
        int minLength = Integer.MAX_VALUE;
        int[] minIndices = { -1, -1 };

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);

                if (map.get(current) == 0) {
                    wordCount -= 1;
                }
            }

            if (wordCount == 0) {
                while (left <= right && wordCount == 0) {
                    int currentLength = right - left;
                    if (currentLength < minLength) {
                        minLength = currentLength;
                        minIndices = new int[] { left, right + 1 };
                    }

                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);

                        if (map.get(leftChar) == 1) {
                            wordCount += 1;
                        }
                    }

                    left += 1;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minIndices[0], minIndices[1]);
    }

}
