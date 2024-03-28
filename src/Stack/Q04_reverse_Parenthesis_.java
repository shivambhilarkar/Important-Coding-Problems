package Stack;

import java.util.Scanner;
import java.util.Stack;

//how many reversal will be needed to make an unbalanced expression to balanced expression...
public class Q04_reverse_Parenthesis_ {

      public static void min_reverse(String str){
            if(str.length () % 2 != 0){
                  System.out.println ("Not possible!!");
                  return;
            }
            //eliminate balanced expression
            Stack<Character> stack = new Stack<> ();
            for(char ch : str.toCharArray ()){
                  if(ch == '('){
                        stack.push (ch);
                  }else{
                        if(!stack.isEmpty() && stack.peek() == ')' ){
                              stack.pop();
                        }else{
                              stack.push(ch);
                        }
                  }
            }

            int openCount = 0;
            int closeCount = 0;
            while(!stack.isEmpty ()){
                  if(stack.pop() == '('){
                        openCount += 1;
                  }else{
                        closeCount += 1;
                  }
            }
            int reversal = (int)Math.ceil (openCount / 2.0) + (int)Math.ceil (closeCount/2.0);
            System.out.println("Reversal : "+reversal);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String expression = ")(())(((";
      }
}
