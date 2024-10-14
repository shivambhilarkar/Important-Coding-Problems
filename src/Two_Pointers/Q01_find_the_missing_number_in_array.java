package Two_Pointers;

import java.util.HashSet;
import java.util.Scanner;
//given number 1 - n find missing number from them
public class Q01_find_the_missing_number_in_array {
      public static void find_missing_1(int[] arr){
            HashSet<Integer> set = new HashSet<> ();
            for(int num : arr){
                  set.add(num);
            }
            for(int i = 1; i <= set.size (); i++){
                  if(set.contains(i) == false){
                        System.out.println("Missing Number : "+ i );
                        return ;
                  }
            }
      }

      public static void find_missing_2(int[] arr , int range){
            int sum = 0;
            for(int i = 1; i <= range; i++){
                  sum ^= i;
            }
            for(int num : arr){
                  sum ^= num;
            }
            System.out.println("Missing Number : "+sum);
            return;

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] arr = {1,2,3,5,6,7,8};
            find_missing_1 (arr);
            find_missing_2 (arr , 8);
      }

}
