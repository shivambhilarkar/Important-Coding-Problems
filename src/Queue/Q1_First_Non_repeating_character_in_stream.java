package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Q1_First_Non_repeating_character_in_stream {

    public void firstNotRepeating(String str) {
        if (str == null || str.isEmpty()) return;

        int[] charCount = new int[26];
        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            queue.add(ch);
            //increase the frequency
            charCount[ch - 'a'] += 1;

            //print first non-repeating character
            while (!queue.isEmpty()) {
                if (charCount[queue.peek() - 'a'] > 1) {
                    queue.remove();
                } else {
                    System.out.println(queue.peek());
                    break;
                }
            }
            //if queue is empty that means no unique characters
            if (queue.isEmpty()) {
                System.out.println(-1);
            }
        }
    }


    public static void main(String[] args) {

    }
}
