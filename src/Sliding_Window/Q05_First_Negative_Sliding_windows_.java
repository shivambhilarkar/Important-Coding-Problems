package Sliding_Window;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q05_First_Negative_Sliding_windows_{
      public static void first_negative_sliding_window(int[] arr, int window_size){
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for(int i = 0; i < arr.length; i++){
                  if(queue.size () > 0 && queue.peek() <= i-window_size){
                        queue.remove();
                  }
                  if(arr[i] < 0){
                        queue.add(i);
                  }
//                  window of size k
                  if(i >= window_size-1){
                        if(queue.size() > 0){
                              System.out.print(arr[queue.peek()] + " ");
                        }else{
                              System.out.print("NAN" + " ");
                        }
                  }
            }
      }
      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {13, -2, -6, 10, -14, 50 , 14, 21};
            int window_size = 3;
            first_negative_sliding_window(arr, window_size);
      }
}
