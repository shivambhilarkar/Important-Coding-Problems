package Two_Pointers;

import java.util.Scanner;

//you have given an array find out pair with min difference
public class Q08_find_pair_with_minimum_difference {
      public static void find_pair(int[] arr){
            int size = arr.length;
            int a = -1, b = -1;
            
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < size-1; i++){
                  int diff = Math.abs(arr[i] - arr[i+1]);
                  if(diff < min){
                        min = diff;
                        a = arr[i];
                        b = arr[i+1];
                  }
            }
            System.out.println("a : "+ a + " b : "+b);
      }
      
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {2,3,4,5,6,7,8,3,4,5};
            find_pair (arr);
      }
}
