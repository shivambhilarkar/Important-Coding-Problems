import java.util.Scanner;


//1. Find max element in rotated array.
//2. Find max element index in rotated array.
public class Q5_Find_max_in_Rotated_array {
      public static int find_max(int[] arr, int start, int end){
            if(start > end){
                  return -1;
            }

            int mid = (start + end) / 2;
            if(arr[mid] > arr[mid+1]){
                  System.out.println("Max : "+arr[mid]);
                  return arr[mid]; //if we want index then just return mid;
            }

            if(arr[start] <= arr[mid]){
                  return  find_max (arr, mid+1, end);
            }else{
                  return find_max (arr, start, mid-1);
            }

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {7,8,9,10,1,2,3,4,5,6};
            int max = find_max (arr, 0, arr.length-1);

      }

}
