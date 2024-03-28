package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q07_Next_Smaller_Element_Monotonic_Stack_ {
      public static void next_smaller_(int[] arr){
            int[] output = new int[arr.length];
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < arr.length; i++){
                  int curr = arr[i];
                  //remove greater element than curr
                  while(!stack.isEmpty() && arr[stack.peek()] > curr){
                        int index = stack.pop();
                        output[index] = curr;
                  }
                  stack.push(i);
            }
            while(!stack.isEmpty()){
                  int index = stack.pop();
                  output[index] = -1; //smaller element not available.
            }
            System.out.println("Next Smaller : "+ Arrays.toString(output));

      }
      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {6,3,9,8,10,2,1,15,7};
            next_smaller_(arr);
      }
}
