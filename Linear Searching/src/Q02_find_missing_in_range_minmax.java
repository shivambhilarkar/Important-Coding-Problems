import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//find min max from array & find missing values from min-max;
public class Q02_find_missing_in_range_minmax {

      public static void find_missing(int[] arr){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            Arrays.sort(arr);
            ArrayList<Integer> list = new ArrayList<> ();
            int value = arr[0];
            int i = 0;
            while(i < arr.length){
                  if(value == arr[i]){
                        value += 1;
                        i += 1;
                  }else{
                        list.add(value);
                        value += 1;
                  }
            }
            System.out.println("Missing Numbers : "+list);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            int[] arr = {1,2,3,4,5,6,8,9};
            find_missing (arr);

      }

}
