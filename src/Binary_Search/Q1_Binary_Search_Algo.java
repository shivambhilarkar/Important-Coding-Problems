package Binary_Search;

import java.util.Scanner;

//Binary Search Algorithm
//Binary search is only possible if given sequence is sorted order
//Sequence should be monotonic in nature.
public class Q1_Binary_Search_Algo {
//      Binary search interative version..
      public static void Binary_Search_Iterative(int[] arr , int searchValue){

            int start = 0;
            int end = arr.length-1;
            while(start < end){
                  int mid = (start + end) / 2;
                  if(arr[mid] == searchValue){
                        System.out.println("Element is Found at index "+mid);
                        return;
                  }else if(arr[mid] < searchValue){
                        start = mid + 1;
                  }else{
                        end = mid - 1;
                  }
            }
            System.out.println("Element is Not found!!!");
      }

//      Binary search Recursive version..
      public static int Binary_Search_Recursive(int[] arr, int searchValue , int start, int end){
            if(start > end){
                  System.out.println("Element is Not Found!!!");
                  return -1;
            }

            int mid = (start + end) / 2;
            if(arr[mid] == searchValue){
                  System.out.println("Element is Found at index "+mid);
                  return mid;
            }else if(arr[mid] < searchValue){
                  return Binary_Search_Recursive (arr, searchValue, mid+1, end);
            }else{
                  return Binary_Search_Recursive (arr, searchValue, start , mid-1);
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);

            int[] arr = {1,2,3,4,5,6,7,8,9,10};
            Binary_Search_Iterative (arr, 2);
//            Binary_Search_Recursive (arr, 15,0, arr.length-1);
      }
}
