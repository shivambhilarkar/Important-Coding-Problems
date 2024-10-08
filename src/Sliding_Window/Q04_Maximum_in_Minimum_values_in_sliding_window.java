package Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Q04_Maximum_in_Minimum_values_in_sliding_window {
    public static void max_min_sliding_window(int[] arr, int window_size) {
        ArrayList<Integer> mins = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
//                  remove out of range element
            if (!queue.isEmpty() && queue.peek() <= i - window_size) {
                queue.removeFirst();
            }
//                  remove greter element at left
            while (!queue.isEmpty() && arr[queue.peekLast()] >= curr) {
                queue.removeLast();
            }
            queue.add(i);
            if (i >= window_size - 1) {
                int min = arr[queue.peekFirst()];
                mins.add(min);
                maximum = Math.max(min, maximum);
            }
        }
        System.out.println("Mins : " + mins);
        System.out.println("Max in minimums : " + maximum);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = {11, 2, 75, 92, 59, 90, 55};
        int window_size = 3;
        max_min_sliding_window(array, window_size);
    }
}
