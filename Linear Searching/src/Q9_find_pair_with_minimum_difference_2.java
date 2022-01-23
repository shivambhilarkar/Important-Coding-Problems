//you have given two array
//find pair such that their difference in minimum

import java.util.Arrays;
import java.util.Scanner;

public class Q9_find_pair_with_minimum_difference_2 {
      public static void find_pair_1(int[] arr1, int[] arr2){

            Arrays.sort(arr1);
            Arrays.sort(arr2);


            int first = 0;
            int second = 0;
            int min = Integer.MAX_VALUE;
            int a = -1, b = -1;

            while(first < arr1.length && second < arr2.length){
                  int diff = Math.abs(arr1[first] - arr2[second]);
                  if(diff < min){
                        min = diff;
                        a = arr1[first];
                        b = arr2[second];
                  }

                  if(arr1[first] < arr2[second]){
                        first += 1;
                  }else{
                        second += 1;
                  }
            }
            System.out.println("a : "+a+"  b :"+b);

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr1 = {2,3,4,5,6,7};
            int[] arr2 = {11,13,16,17,19,12};

            find_pair_1 (arr1, arr2);
      }
}
