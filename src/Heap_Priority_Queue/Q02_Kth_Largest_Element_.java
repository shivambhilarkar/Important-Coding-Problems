package Heap_Priority_Queue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q02_Kth_Largest_Element_{
      public static void kth_largest(int[] arr, int kth){
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int num : arr){
                  if(queue.size() < kth){
                        queue.add(num);
                  }else{
                        queue.remove();
                        queue.add(num);
                  }
            }
            System.out.println("Kth largest : "+queue.peek());
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = { 1,2,3,4,5,6,7,8,9,10};
            int kth = 3;
            kth_largest (arr, kth);
      }
}
