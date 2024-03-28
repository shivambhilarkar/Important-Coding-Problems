package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
//!!!!!!!Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
public class Q08_Next_Greater_Circular_Monotonic_Stack{
      public static void next_greater_(int[] arr){
            Stack<Integer> stack = new Stack<>();
            int[] output = new int[arr.length];

            int size = arr.length;
            for(int i = 0; i < (2 * size-1); i++){
                  int curr = arr[i%size];
                  while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                        int index = stack.pop();
                        output[index] = curr;
                  }
                  stack.push(i % size);
            }
            while(!stack.isEmpty()){
                  int index = stack.pop();
                  output[index] = -1; //greater element not available.
            }
            System.out.println("Next Greater Circular : "+ Arrays.toString(output));
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {6,3,9,8,10,2,1,15,7};
            next_greater_(arr);

      }
}
