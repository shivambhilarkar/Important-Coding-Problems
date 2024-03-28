package Binary_Search.Set_1;

import java.util.Scanner;
//find the first index of 1;
public class Q03_Search_in_01_list {
      public static int binary_search_appraoch(int[] array){
            if(array[0] == 1) return 0;
            return get_first_Index(array);
      }
      public static int get_first_Index(int[] array){
            int start = 0;
            int end = array.length-1;
            while(start <= end){
                  int mid = start + (end - start) / 2;
                  if(mid != 0 && array[mid] == 1 && array[mid-1] == 0){
                        return mid;
                  }
                  if(array[mid] < 1){
                        start = mid + 1;
                  }else{
                        end = mid - 1;
                  }
            }
            return -1;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] array = {0,0,0,1,1,1,1};
            System.out.println(binary_search_appraoch (array));

      }
}
