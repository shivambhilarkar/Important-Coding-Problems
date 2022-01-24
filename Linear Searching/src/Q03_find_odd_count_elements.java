import java.util.HashMap;
import java.util.Scanner;

//given a array where all elements appear even number of times except one element ouccurs
//odd number of time find that element
public class Q03_find_odd_count_elements {
      public static void find_count_1(int[] arr){
            HashMap<Integer, Integer> freq_map = new HashMap<> ();
            for(int num : arr){
                  freq_map.put(num, freq_map.getOrDefault (num , 0)+1);
            }
            for(int num : freq_map.keySet()){
                  if(freq_map.get(num) % 2 == 1){
                        System.out.println("Odd Count Number : "+num);
                        return;
                  }
            }
      }
      public static void find_count_2(int[] arr){
            int sum = 0;
            for(int num : arr){
                  sum ^= num;
            }
            System.out.println("Missing Number : "+sum);
            return;
      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] arr = {1,1,2,2,3,3,3,4,4,4,4,5,5};
            find_count_1 (arr);
            find_count_2 (arr);

      }
}
