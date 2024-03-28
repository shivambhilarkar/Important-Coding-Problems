package Binary_Search;

import java.util.Scanner;

//we have given a array
//we have to find index where elements ..index-1 sum == elements at index+1.. sum
public class Q8_Find_the_balance_point_ {
      public static void find_Balance_point(int[] arr){
            int right = 0;
            for(int i = 1; i < arr.length; i++){
                  right += arr[i];
            }

            int left = 0;
            for(int i = 0; i < arr.length; i++){
                  if(left == right){
                        System.out.println("Balanced Point at index: "+i);
                        return;
                  }
                  if(i < arr.length-1){
                        left += arr[i];
                        right -= arr[i+1];
                  }
            }
            System.out.println("No Balanced Point...");
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] array = {1,2,3,4,5,4,6};
            find_Balance_point (array);
      }
}
