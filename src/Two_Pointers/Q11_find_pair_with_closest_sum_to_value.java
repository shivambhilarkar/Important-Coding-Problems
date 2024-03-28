package Two_Pointers;

import java.util.Arrays;
import java.util.Scanner;

public class Q11_find_pair_with_closest_sum_to_value {
      public static void find_pair1(int[] arr, int value){
            Arrays.sort(arr);

            int start = 0;
            int end = arr.length-1;
            int min_diff = Integer.MAX_VALUE;

            int a = -1, b = -1;
            while(start < end){
                  int curr_diff = Math.abs(value -  (arr[start] + arr[end]));
                  if(curr_diff < min_diff){
                        min_diff = curr_diff;
                        a = arr[start];
                        b = arr[end];
                  }

                  if(curr_diff > 0){
                        start += 1;
                  }else{
                        end -= 1;
                  }
            }
            System.out.println("a : "+a + "  b : "+b +" @ "+min_diff);

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,-3,-10,6,18, 9,-15};
            int value = 5;
            find_pair1 (arr, value);
      }
}
