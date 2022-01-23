//Given two sorted list find median of two list if we combine both list.

import java.util.Scanner;

public class Q4_Find_median_of_two_sorted_list {
      public static void find_median(int[] arr1, int[] arr2){
            int size1= arr1.length;
            int size2 = arr2.length;

            int medianIndex = ((size1+size2) + (size1+size2) % 2) / 2; //cealing function
            int currIndex = 0;

            int first = 0;
            int second = 0;
            while(currIndex < medianIndex-1){
                  if(first < size1-1 && arr1[first] < arr2[second]){
                        first += 1;
                  }else{
                        second += 1;
                  }
                  currIndex += 1;
            }

            if(arr1[first] < arr2[second]){
                  System.out.println("Median : "+arr1[first]);
            }else{
                  System.out.println("Median : "+arr2[second]);
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr1 = {1,2,3,4,5,6};
            int[] arr2 = {7,8,9,10,11,12};
            find_median (arr1, arr2);
      }
}
