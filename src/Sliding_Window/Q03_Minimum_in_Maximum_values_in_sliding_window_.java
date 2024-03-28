package Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Q03_Minimum_in_Maximum_values_in_sliding_window_ {
      public static void min_max_sliding_window(int[] arr, int window_size){
            int minimum = Integer.MAX_VALUE;
            ArrayList<Integer> maxes = new ArrayList<>();
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for(int i = 0; i < arr.length; i++){
                  int curr = arr[i];
//                  remove out of range element
                  if(queue.size() > 0 && queue.peek() <= i-window_size){
                        queue.remove();
                  }
//                  remove smaller element from left
                  while(queue.size() > 0 && arr[queue.peekLast()] <= curr){
                        queue.removeLast();
                  }
                  queue.add(i);
                  if(i >= window_size-1){
                        int max = arr[queue.peek()];
                        maxes.add(max);
                        minimum = Math.min(max, minimum);
                  }
            }
            System.out.println("Maxes : "+maxes);
            System.out.println("Min in Maxs : "+minimum);
      }

      public static void main(String[] args) {
            Scanner scan = new Scanner (System.in);
            int[] array = {11, 2, 75, 92, 59, 90, 55};
            int window_size = 3;
            min_max_sliding_window (array, window_size);
      }

}
