package Sorting;

import java.util.Arrays;
import java.util.Scanner;

//Given an array of integer and a range.
//partition array such that   (element < range) --->  (element > low & element < high) ---> (element > high)
public class Q3_Range_Partition_ {
      public static void range_Partition(int[] arr, int lower, int higher){
            int start = 0;
            int end = arr.length-1;
            int i = 0;

            while(i <= end){
                  if(arr[i] < lower){
                        swap(arr, i, start);
                        start += 1;
                        i += 1;
                  }else if(arr[i] > higher){
                        swap(arr, i, end);
                        end -= 1;
                  }else{
                        i += 1;
                  }
            }
            System.out.println("Partitioned Array : "+ Arrays.toString (arr));
      }
      public static void swap(int[] arr, int start, int end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,21,2,20,3,19,4,18,5,17,6,16,7,15,8,14,9,13,10,12,11};
            int low = 9;
            int high = 12;
            range_Partition (arr, low, high);
      }
}
