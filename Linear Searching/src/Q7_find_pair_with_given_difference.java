import java.util.Arrays;
import java.util.Scanner;

//you have given array find out pair who has difference equal to given value
public class Q7_find_pair_with_given_difference {
      public static void find_pair1(int[] arr , int value){

            Arrays.sort(arr);
            int first = 0;
            int second = 0;
            int size = arr.length;

            while(first < size && second < size){
                  int diff = Math.abs(arr[first] - arr[second]);

                  if(diff == value){
                        System.out.println("a : "+arr[first] +"  b : "+arr[second]);
                        return;
                  }else if(diff < value){
                        second += 1;
                  }else{
                        first += 1;
                  }
            }
            System.out.println("Not Found !!!");

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {2,3,4,5,6,7,8,3,4,5};
            find_pair1 (arr, 6);
      }
}
