package Two_Pointers;

import java.util.Scanner;

//given a array where all elements appear even number of time except two numbers appear
//odd number of time find that number;
public class Q04_find_odd_count_element2 {
      public static void find_number(int[] arr){
            int xorsum = 0;
            for(int num : arr){
                  xorsum ^= num;
            }
//            rightmost set bit.
            int setBit = xorsum & ~(xorsum-1);

            int first = 0;
            int second = 0;

//            Dividing elements in two group: Elements having setbit 1 & having setbit 0
//            Even elements cancelled themselves if group and we get our numbers.
            for(int i = 0; i < arr.length; i++){
                  if((setBit & arr[i]) != 0){
                        first ^= arr[i];
                  }else{
                        second ^= arr[i];
                  }
            }
            System.out.println("a : "+first + "  b : "+second);

      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,1,2,2,3,3,3,4,4,5,5,5};
            find_number (arr);
      }
}
