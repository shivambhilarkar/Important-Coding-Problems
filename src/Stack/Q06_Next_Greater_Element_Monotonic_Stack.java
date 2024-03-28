package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


//Monotonic Stack Problem.

public class Q06_Next_Greater_Element_Monotonic_Stack {
      public static void next_greater_(int[] arr){
            int[] output = new int[arr.length];
            Stack<Integer> stack = new Stack<> ();

            for(int i = 0; i < arr.length; i++){
                  int curr = arr[i];
                  //remove smaller
                  while(!stack.isEmpty() && arr[stack.peek()] <= curr){
                        int index = stack.pop();
                        output[index] = curr;
                  }
                  stack.push(i);
            }


            while(!stack.isEmpty()){
                  int index = stack.pop();
                  output[index] = -1; //don't have next greater element
            }
            System.out.println("Next Greater : "+ Arrays.toString(output));
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] arr = {6,3,9,8,10,2,15,7};
            next_greater_(arr);
      }
}
