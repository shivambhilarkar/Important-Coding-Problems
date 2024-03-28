package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//In the given list of daily stock price in an array A[i].
//Find the span of the stock for each day.
//A span of stock is the maximum number of days for which the price of stock was lower than that day.
public class Q09_Stock_span_problem_ {
      public static void stock_span(int[] arr){
            Stack<Integer> stack = new Stack<>();
            int[] span = new int[arr.length];

            stack.push(0);
            span[0] = 1;
            for(int i = 1; i < arr.length; i++){
                  while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                        stack.pop();
                  }
                  if(stack.isEmpty ()){
                        span[i] = i+1;
                  }else{
                        span[i] = (i - stack.peek());
                  }
            }
            System.out.println("Stock Span : "+ Arrays.toString(span));
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int[] arr = {6,5,4,3,2,4,5,7,9};
            stock_span (arr);
      }
}
