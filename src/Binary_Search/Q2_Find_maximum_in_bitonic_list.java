package Binary_Search;//Bitonic list comprise of an increasing sequence of integers immediatly followed by a decreasing
//sequence of integers && sequence should not have repeatations.

import java.util.Scanner;

public class Q2_Find_maximum_in_bitonic_list {
      public static void find_maximum(int[] arr){

            int start = 0;
            int end = arr.length-1;
            while(start <= end){
                  int mid = (start + end) / 2;

                  if(arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid]){
                        System.out.println("Maximum : "+arr[mid] +" at index "+mid);
                        return;
                  }else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]){
                        start = mid + 1;
                  }else if(arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]){
                        end = mid - 1;
                  }
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,2,3,4,5,6,7,8,7,6,5,4};
            find_maximum (arr);

      }
}
