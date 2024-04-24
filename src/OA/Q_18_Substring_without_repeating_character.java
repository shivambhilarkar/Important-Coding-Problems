package OA;

import java.util.HashMap;
import java.util.Map;

public class Q_18_Substring_without_repeating_character {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int end = 0;
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (map.containsKey(ch)) {
                while (map.containsKey(ch)) {
                    char last = s.charAt(end);
                    map.remove(last);
                    end += 1;
                }
            }
            result = Math.max(result, index - end + 1);
            map.put(ch, 1);
        }
        return result;
    }

}
