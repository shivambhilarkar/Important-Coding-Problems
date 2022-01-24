import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//given two array a & b
//find out pair from both array which from sum == value;
public class Q06_find_pair_in_array2 {
      public static void find_pair1(int[] arr1, int[] arr2, int value){

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int start = 0;
            int end = arr2.length-1;
            while(start < arr1.length && end >= 0){
                  int curr = arr1[start] + arr2[end];
                  if(curr == value){
                        System.out.println("a : "+arr1[start] +"  b : "+arr2[end]);
                        start += 1;
                        end -=1;
                  }else if(curr < value){
                        start += 1;
                  }else{
                        end -= 1;
                  }
            }
      }

      public static void find_pair2(int[] arr1, int[] arr2, int value){
            HashMap<Integer, Integer> freq_map = new HashMap<> ();
            for(int num : arr1){
                  freq_map.put(num, freq_map.getOrDefault(num, 0) + 1);
            }

            for(int num : arr2){
                  if(freq_map.containsKey(value - num)){
                        System.out.println("a : "+num +"  b : "+ (value-num));
                  }
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr1 = {2,3,4,5,6,7};
            int[] arr2 = {2,3,4,5,6,7};
            int value = 10;
//            find_pair1 (arr1, arr2, value);
            find_pair2(arr1, arr2, value);

      }
}
