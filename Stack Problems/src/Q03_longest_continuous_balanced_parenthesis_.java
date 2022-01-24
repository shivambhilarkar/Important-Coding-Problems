import java.util.Scanner;
import java.util.Stack;

public class Q03_longest_continuous_balanced_parenthesis_ {
      public static void longest_parenthesis(String expression){
            Stack<Integer> stack = new Stack<> ();
            stack.push (-1);
            int length = 0;
            for(int i = 0; i < expression.length(); i++){
                  char ch = expression.charAt(i);
                  if(ch == '('){
                        stack.push(i);
                  }else{
                        stack.pop();
                        if(stack.size () != 0){
                              length = Math.max(length, i- stack.peek());
                        }else{
                              stack.push(i);
                        }
                  }
            }
            System.out.println ("Longest Balanced Length : "+length);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            String expression = "())((()))(())()(()";
            longest_parenthesis (expression);
      }
}
