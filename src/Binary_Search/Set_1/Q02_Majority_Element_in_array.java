package Binary_Search.Set_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Element which occurs more than [n/2] times
public class Q02_Majority_Element_in_array {
      public static int brute_force(int[] array){
            int count = array.length / 2;
            HashMap<Integer,Integer> map = new HashMap<> ();
            for(int num : array){
                  map.put(num, map.getOrDefault (num, 0) + 1);
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet ()){
                  if(entry.getValue () > count){
                        return entry.getKey ();
                  }
            }
            return -1;
      }

      //optimise approach
      public static int binary_search(int[] array){
            int mid = array.length / 2;
            int majority = array[mid];

            int firstIndex = get_first_Index(array, majority);
            if(firstIndex + mid < array.length && array[firstIndex + mid] == majority){
                  return majority;
            }else{
                  return -1;
            }

      }
      //function to get first Index of majority element
      public static int get_first_Index(int[] array, int element){
            int start = 0;
            int end = array.length-1;
            while(start <= end){
                  int mid = start + (end - start ) / 2;

                  if(mid != 0 && array[mid] == element && array[mid-1] != element){
                        return mid;
                  }
                  if(array[mid] < element){
                        start = mid + 1;
                  }else{
                        end = mid - 1;
                  }
            }
            return -1;
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] array = {2,2,1,1,1,2,2};
            Arrays.sort(array);
            System.out.println(brute_force (array));

            System.out.println(binary_search (array));
      }
}
