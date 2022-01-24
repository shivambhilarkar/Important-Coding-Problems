package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Given two array, sort first array according to the order defined in second array.
public class Q5_Sort_by_order_ {
      public static void sort_by_order(int[] arr1, int[] arr2){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : arr1){
                  map.put(num, map.getOrDefault (num, 0) + 1);
            }

            ArrayList<Integer> order = new ArrayList<>();
            for(int num : arr2){
                  if(map.containsKey(num)){
                        int freq = map.get(num);
                        for(int i = 0; i < freq; i++){
                              order.add(num);
                        }
                        map.remove(num);
                  }
            }
            for(int num : arr1){
                  if(map.containsKey (num)){
                        int freq = map.get(num);
                        for(int i = 0; i < freq; i++){
                              order.add(num);
                        }
                        map.remove(num);
                  }
            }
            System.out.println("Array : "+ order);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr1 = {2,1,2,5,7,1,9,3,6,8,8};
            int[] arr2 = {2,1,8,3};
            sort_by_order (arr1, arr2);



      }
}
