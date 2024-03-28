package Sorting;

import java.util.Arrays;
import java.util.Scanner;

//given array separate odd even numbers from array
public class Q6_Separate_odd_even_ {
      public static void separete_Odd_Even(int[] arr){
            int start = 0;
            int end = arr.length-1;

            while(start < end){
                  if(arr[start] % 2 == 0){
                        start += 1;
                  }else if(arr[end] % 2 == 1){
                        end -= 1;
                  }else{
                        int temp = arr[start];
                        arr[start] = arr[end];
                        arr[end] = temp;
                  }
            }
            System.out.println("Array : "+ Arrays.toString (arr));
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] array = {1,2,3,4,5,6,7,8,9,10};
            separete_Odd_Even (array);
      }
}
