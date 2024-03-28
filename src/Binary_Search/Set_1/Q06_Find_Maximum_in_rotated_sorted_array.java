package Binary_Search.Set_1;

import java.util.Arrays;
import java.util.Scanner;

public class Q06_Find_Maximum_in_rotated_sorted_array {

      public static int binary_search_approach(int[] array) {
            int start = 0;
            int end = array.length - 1;

            while (start <= end) {
                  int mid = start + (end - start) / 2;

                  // BASE CONDITION
                  if (mid != array.length - 1 && array[mid] > array[mid + 1]) {
                        return mid;
                  }

                  if (array[start] <= array[mid]) {
                        start = mid + 1;
                  } else {
                        end = mid - 1;
                  }
            }
            return -1;
      }

      public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int[] array = { 4, 5, 6, 7, 0, 1, 2 };
            Arrays.sort(array);
            System.out.println(binary_search_approach(array));

      }
}
