package BFS;

import java.util.*;

public class Q03_Word_Ladder {

    public int getLadderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;

        Set<String> dictionary = new HashSet<>(wordList);

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        int steps = 0;
        while (queue.isEmpty() == false) {

            int size = queue.size();
            steps += 1;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return steps;
                }

                for (int j = 0; j < current.length(); j++) {
                    char[] str = current.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        str[j] = ch;
                        String newString = new String(str);
                        if (dictionary.contains(newString)) {
                            queue.add(newString);
                            dictionary.remove(newString);
                        }
                    }
                }
            }
        }
        //not possible
        return -1;
    }


    public static void main(String[] args) {

    }

}
