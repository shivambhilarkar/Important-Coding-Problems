import java.util.HashMap;
import java.util.Scanner;

//Given an array of integers, we have to find out if duplicate value exist or not at range of k units..
public class Q9_find_Duplicate_present_at_k_distance {
      public static void find_Duplicate(int[] arr , int range){
            HashMap<Integer, Integer> indexMap = new HashMap<> ();
            for(int i = 0; i < arr.length; i++){
                  if(indexMap.containsKey (arr[i]) && (i - indexMap.get(arr[i]) <= range)){
                        System.out.println("Duplicate Exist");
                        return;
                  }else{
                        indexMap.put(arr[i] , i);
                  }
            }
            System.out.println("Duplicate Doesn't Exist");
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {1,2,3,6,4,5};
            int range = 3;
            find_Duplicate (arr, range);
      }
}
