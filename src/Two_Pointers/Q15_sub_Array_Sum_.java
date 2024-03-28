package Two_Pointers;

import java.util.Scanner;

//Given an array of integers , you need to find if there is some range in array such that
//their sum of elements == value;
public class Q15_sub_Array_Sum_ {
      public static void sub_array_sum(int[] arr,int value){
            int first = 0;
            int second = 0;

            int sum = arr[first];
            while(first < arr.length && second< arr.length){
                  if(sum == value){
                        System.out.println("Subarray found ");
                        return;
                  }
                  if(sum < value){
                        second += 1;
                        if(second < arr.length){
                              sum += arr[second];
                        }
                  }else{
                        sum -= arr[first];
                        first += 1;
                  }
            }
            System.out.println("Not found.");
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {1,2,3,4,5,4,5,7,8,9};
            int value = 13;
            sub_array_sum (arr, value);
      }
}
