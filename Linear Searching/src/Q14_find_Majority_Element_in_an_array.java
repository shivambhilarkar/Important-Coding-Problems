import java.util.Arrays;
import java.util.Scanner;

//Solution :
//Sort all the array . if there is a majority then the middle element at the index n/2
//must be the majority number.
//Now scan the array and count how many time element is appear. if count == n/2

public class Q14_find_Majority_Element_in_an_array {

      public static void find_majority(int[] arr){

            Arrays.sort(arr);
            int size = arr.length;
            int possible_m = arr[size/2];
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                  if(possible_m == arr[i]){
                        count += 1;
                  }
            }

            if(count == size/2){
                  System.out.println("Majority Element : "+possible_m);
            }else{
                  System.out.println("Majority Element is absent...");
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {1,2,3,4,4};
            find_majority(arr);

      }
}
