//Given sorted list find the number of occurrences of a number.
//1. first solution . --> we can use linear search and count the occurrences.

//2. second solution . --> using binary search find out first occurrence of number.
//then again find out last occurrence of number.
//then count = last_index - first_index + 1;

import java.util.Scanner;

public class Q3_Find_occurrence_of_value_in_list {
      public static int get_first_index(int[] arr, int value, int start , int end){
            if(start > end){
                  return -1;
            }
            int mid = (start + end) / 2;
            if(arr[mid] == value && (mid == start || arr[mid-1] != value)){
                  return mid;
            }
            if(value <= arr[mid]){
                  return get_first_index (arr, value, start, mid-1);
            }else{
                  return get_first_index (arr, value , mid+1, end);
            }
      }
      public static int get_last_index(int[] arr, int value, int start, int end){
            if(start > end){
                  return -1;
            }

            int mid = (start + end) / 2;
            if(arr[mid] == value && (mid == end || arr[mid+1] != value)){
                  return mid;
            }

            if(value < arr[mid]){
                  return get_last_index (arr, value , start, mid-1);
            }else{
                  return get_last_index (arr, value, mid+1, end);
            }
      }
      public static void find_count(int[] arr , int value){

            int first_index = get_first_index (arr, value, 0, arr.length-1);
            int last_index = get_last_index (arr, value, 0, arr.length-1);

            int count = last_index - first_index + 1;
            if(first_index == -1 || last_index == -1){
                  System.out.println ("Not Found");
            }else{
                  System.out.println("Number "+value+ " is occurre "+count +" time");
            }

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,2,3,4,5,6,6,6,6};
            find_count (arr, 6);
            find_count (arr, 7);
      }
}
