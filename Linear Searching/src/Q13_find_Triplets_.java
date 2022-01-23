//1. find triplets sum equal to zero
//2. find triplets sum equal to value
//3. find triplets such that a + b = c

import java.util.Arrays;
import java.util.Scanner;

public class Q13_find_Triplets_ {
      //1. find triplets sum equal to zero
      public static void find_triplets_1(int[] arr){
            Arrays.sort(arr);
            int size = arr.length;
            for(int i = 0; i < (size-2); i++){
                  int start = i + 1;
                  int stop = size - 1;
                  while(start < stop){
                        int sum = arr[i] + arr[start] + arr[stop];
                        if(sum == 0){
                              System.out.println("["+arr[i]+","+arr[start]+","+arr[stop]+"]");
                              start += 1;
                              stop -= 1;
                        }else if(sum < 0){
                              start += 1;
                        }else{
                              stop -= 1;
                        }
                  }
            }
      }
      //2. find triplets sum equal to value
      public static void find_triplets_2(int[] arr, int value){

            Arrays.sort(arr);
            int size = arr.length;

            for(int i = 0; i < size-2; i++){
                  int start = i+1;
                  int end = size-1;
                  while(start < end){
                        int sum = arr[i] + arr[start] + arr[end];
                        if(sum == value){
                              System.out.println("["+arr[i]+","+arr[start]+","+arr[end]+"]");
                              start += 1;
                              end -= 1;
                        }else if(sum < value){
                              start += 1;
                        }else{
                              end -= 1;
                        }
                  }
            }
      }

      //3. find triplets such that a + b = c
      public static void find_triplets_3(int[] arr){

            Arrays.sort (arr);
            int size = arr.length;

            for(int i = 0; i < (size-2); i++){
                  int start = i + 1;
                  int end = size-1;
                  while(start < end){
                        int sum = arr[start] + arr[end];
                        if(arr[i] == sum){
                              System.out.println(arr[start] + " + "+arr[end] +" = "+arr[i]);
                              start += 1;
                              end -= 1;
                        }else if(arr[i] > sum){
                              end -= 1;
                        }else{
                              start += 1;
                        }
                  }
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {1,-3,-10,6,18, 9,-15,2,2,4};
//            find_triplets_1 (arr);
//            find_triplets_2 (arr, 0);
            find_triplets_3 (arr);

      }
}
