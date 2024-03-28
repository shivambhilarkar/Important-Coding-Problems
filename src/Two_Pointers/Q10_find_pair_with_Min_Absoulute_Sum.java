package Two_Pointers;

import java.util.Arrays;
import java.util.Scanner;

//given an array of integers of both +ve & -ve values.
//find two elements in the array such that their sum is minimum.
public class Q10_find_pair_with_Min_Absoulute_Sum {
      public static void find_pair1(int[] arr){

            Arrays.sort(arr);
            int start = 0;
            int end = arr.length-1;
            int a = -1, b = -1;
            int minsum = Integer.MAX_VALUE;
            while(start <  end){
                  int sum = Math.abs(arr[start] + arr[end]);
                  if(sum < minsum){
                        minsum = sum;
                        a = arr[start];
                        b = arr[end];
                  }
                  if(sum < 0){
                        start++;
                  }else{
                        end--;
                  }
            }
            System.out.println("a : "+a + "\nb : "+b + "\nsum :"+minsum);
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,-3,-10,6,18, 9,-15};
            find_pair1 (arr);
      }
}
