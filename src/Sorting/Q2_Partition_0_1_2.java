package Sorting;

import java.util.Arrays;
import java.util.Scanner;

//Given an array containing 0s, 1s, 2s.
//write an algorithm to sort the array where 0s --> 1s --> 2s
public class Q2_Partition_0_1_2 {

      public static void sort_0_1_2(int[] arr){
            int start = 0;
            int end = arr.length-1;
            int i = 0;
            while( i <= end){
                  if(arr[i] == 0){
                        swap(arr , i, start);
                        i += 1;
                        start += 1;
                  }else if(arr[i] == 1){
                        i += 1;
                  }else{
                        swap(arr, i, end);
                        end -= 1;
                  }
            }
            System.out.println("Sorted Array : "+ Arrays.toString (arr));
      }
      public static void swap(int[] arr, int start, int end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] array = {2,0,1,0,2,1,0,0,1,2};
            sort_0_1_2 (array);
      }
}
