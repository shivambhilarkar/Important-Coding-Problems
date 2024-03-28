package Heap_Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//give data structure that will provide median in constant time.
public class Q03_Get_Median_ {
      public static class Median_Heap{
            static PriorityQueue<Integer> minQueue;
            static PriorityQueue<Integer> maxQueue;
            Median_Heap(){
                  minQueue = new PriorityQueue<>();
                  maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            }

            public static void insert(int val){
                  if(maxQueue.isEmpty()){
                        maxQueue.add(val);
                  }else{
                        minQueue.add(val);
                  }
                  if(maxQueue.size() > minQueue.size()+1){
                        int data = maxQueue.remove();
                        minQueue.add(data);
                  }
                  if(minQueue.size () > maxQueue.size()+1){
                        int data = minQueue.remove();
                        maxQueue.add(data);
                  }
            }

            public static void get_median(){
                  if(maxQueue.size() == 0) {
                        System.out.println("Underflow...");
                        return;
                  }
                  if(minQueue.size() > maxQueue.size()){
                        int med = minQueue.peek();
                        System.out.println("Med : "+med);
                        return;
                  }else if(minQueue.size() < maxQueue.size()){
                        int med = maxQueue.peek();
                        System.out.println("Med : "+med);
                        return;
                  }else{
                        int med = (minQueue.peek() + maxQueue.peek()) / 2;
                        System.out.println("Med : "+med);
                        return;
                  }
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {1,9,2,8,3,7,4,6,5,1,9,2,8,3,7,4,6,5,10,10};

            Median_Heap med_heap = new Median_Heap();
            for(int num : arr){
                  med_heap.insert(num);
                  med_heap.get_median();
            }
      }

}
