package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Q4_Minimum_swaps_required_to_bring_element_at_one_side {

      public static void partitioned(int[] arr, int val){
            int start = 0;
            int end = arr.length-1;
            int i = 0;

            int min_swap = 0;
            while(start < end){
                  if(arr[start] <= val){
                        start += 1;
                  }else if(arr[end] > val){
                        end -= 1;
                  }else{
                        int temp = arr[start];
                        arr[start] = arr[end];
                        arr[end] = temp;
                        min_swap += 1;
                  }
            }
            System.out.println ("Array : "+ Arrays.toString (arr));
            System.out.println("Min Swaps : "+min_swap);
      }
      public static void swap(int[] arr, int start, int end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] arr = {1,21,2,20,3,19,4,18,5,17,6,16,7,15,8,14,9,13,10,12,11};
            int value = 9;
            partitioned (arr, value);


      }
}
