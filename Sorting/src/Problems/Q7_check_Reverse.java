package Problems;

import java.util.Arrays;
import java.util.Scanner;

//given an array of integers. find if reversing a sub-array makes the array sorted.
public class Q7_check_Reverse {
      public static void check_reverse(int[] arr){
            int start = -1;
            int stop = -1;
            for(int i = 0; i < arr.length-1; i++){
                  if(arr[i] > arr[i+1]){
                        start = i;
                        break;
                  }
            }
            if(start == -1){
                  System.out.println("Already sorted");
                  return;
            }

            for(int i = start; i < arr.length-1; i++){
                  if(arr[i] < arr[i+1]){
                        stop = i;
                        break;
                  }
            }
            if(stop == -1){
                  System.out.println("Already sorted");
            }

            if(arr[start-1] > arr[stop] || arr[stop+1] < arr[start]){
                  System.out.println("Not possible");
                  return;
            }
            for(int i = stop+1; i< arr.length-1; i++){
                  if(arr[i] > arr[i+1]){
                        System.out.println("NOT possible");
                        return;
                  }
            }
            System.out.println("Sorted Array : "+ Arrays.toString (arr));
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,2,3,4,5,8,7,6,9,10};
            check_reverse (arr);
      }
}
