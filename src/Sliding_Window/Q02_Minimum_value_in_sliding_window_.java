package Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Given an array of integers, find maximum value in all the sliding windows of length k.
//Monotonic Queue Appraoch.
public class Q02_Minimum_value_in_sliding_window_ {
    public static void minimum_sliding_window(int[] arr, int window_size) {
        ArrayList<Integer> mins = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
//                  remove out of range element
            if (queue.size() > 0 && queue.peek() <= i - window_size) {
                queue.removeFirst();
            }
//                  remove larger element from left
            while (queue.size() > 0 && arr[queue.peekLast()] >= arr[i]) {
                queue.removeLast();
            }
            queue.add(i);
            if (i >= window_size - 1) {
//                        min element at front of queue
                mins.add(arr[queue.peekFirst()]);
            }
        }
        System.out.println("Mins : " + mins);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = {11, 2, 75, 92, 59, 90, 55};
        int window_size = 3;
        minimum_sliding_window(array, window_size);
    }
}
