

//Given an array find if there is a pair whose sum is equal to the sum of the
//rest of the elements of the array


//Solution :
//Sort the array. sum all the elements of the array call this value total.
//Find a pair in the sorted array whose sum is total / 2.

import java.util.Scanner;

public class Q12_find_pair_sum_of_equal_to_rest_array {
      public static void find_pair1(int[] arr){

            int total = 0;
            for(int num : arr){
                  total += num;
            }
            total = total / 2;

            int start = 0;
            int end = arr.length-1;
            while(start < end){
                  int curr = arr[start]+ arr[end];
                  if(curr == total){
                        System.out.println(" a : "+arr[start] + "  b : "+arr[end]);
                        return;
                  }
                  if(curr < total){
                        start += 1;
                  }else{
                        end -= 1;
                  }
            }
            System.out.println("Pair is Not found !!!");
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,-3,-10,6,18, 9,-15};
            find_pair1 (arr);
      }
}
