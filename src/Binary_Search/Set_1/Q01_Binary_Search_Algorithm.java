package Binary_Search.Set_1;

import java.util.Scanner;
//Search Element in sorted array using binary search
public class Q01_Binary_Search_Algorithm {
      public static boolean search(int[] array, int value){

            int start = 0;
            int end = array.length-1;
            while(start <= end){
                  int mid = start + (end - start) / 2;

                  if(array[mid] == value){
                        return true;
                  }

                  if(array[mid] < value){
                        start = mid + 1;
                  }else{
                        end = mid - 1;
                  }
            }
            return false;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] array = {2,3,4,5,6,7,8,9,10};
            System.out.println(search(array , 7));
      }

}
