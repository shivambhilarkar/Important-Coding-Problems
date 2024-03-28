package Sorting;

import java.util.Arrays;
import java.util.Scanner;

//given array containing 0 & 1.
//write algorithm to sort the array where all zero's come first.
//and also find minimum swaps are required to sort the array.;
public class Q1_Partition_0_1_ {

      public static void sort_1_0(int[] arr){
            int start = 0;
            int end = arr.length-1;

            int swap_count = 0;
            while(start < end){
                  while(arr[start] == 0){
                        start += 1;
                  }
                  while(arr[end] == 1){
                        end -= 1;
                  }

                  if(start < end){
                        swap(arr, start, end);
                        swap_count += 1;
                  }

            }
            System.out.println("Sorted Array : "+ Arrays.toString (arr));
            System.out.println("Minimum Swaps Required to Sort : "+swap_count);
      }
      public static void swap(int[] arr, int start , int end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] array = {1,0,0,1,1,0,1,0,0,1,0,1};
            sort_1_0 (array);
      }
}
