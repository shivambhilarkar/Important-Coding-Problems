import java.util.Arrays;
import java.util.HashMap;

//find two elements such that there sum is equal to value
public class Q5_find_pair_in_array {

//      for single pair
      public static void find_pair1(int[] arr,int value){
            Arrays.sort(arr);
            int start = 0;
            int end = arr.length-1;
            while(start < end){
                  int curr = arr[start] + arr[end];
                  if(curr == value){
                        System.out.println("a : "+arr[start] + "  b : "+arr[end]);
                        return;
                  }else if(curr < value){
                        start += 1;
                  }else{
                        end -= 1;
                  }
            }
            System.out.println("NOT FOUND!!!");
      }
//    for all pairs
      public static void find_pair2(int[] arr, int value){
            HashMap<Integer, Integer> freq_map = new HashMap<> ();
            for(int num : arr){
                  freq_map.put(num , freq_map.getOrDefault (num , 0)+1);
            }

            for(int num : arr){
                  if(freq_map.containsKey(value - num)){
                        System.out.println("a : "+num +"  b : "+(value-num));
                  }
            }


      }

      public static void main(String[] args){
            int[] arr = {2,3,4,5,6,9,2,4,6};
            int value = 6;
//            find_pair1 (arr, value);
            find_pair2 (arr, value);

      }
}
