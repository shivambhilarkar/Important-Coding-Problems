//we have given strings of [ ] { } ( )
//we have to check whether it is balanced or not

import java.util.Scanner;
import java.util.Stack;

public class Q01_Balanced_Parenthesis {
      public static boolean check_balanced(String expression){

            Stack<Character> stack = new Stack<> ();
            for(char ch : expression.toCharArray ()){
                  switch (ch){
                        case '[':
                        case '{':
                        case '(':
                              stack.push(ch);
                              break;
                        case '}':
                              if(stack.pop() != '{'){
                                    System.out.println("Expression is Not Valid");
                                    return false;
                              }
                              break;
                        case ')':
                              if(stack.pop() != '('){
                                    System.out.println("Expression is Not Valid");
                                    return false;
                              }
                              break;
                        case ']':
                              if(stack.pop() != '['){
                                    System.out.println("Expression is Not Valid");
                                    return false;
                              }
                              break;
                        default:
                              System.out.println("Invalid character");
                              return false;
                  }
            }
            System.out.println("Expression is Valid");
            return true;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String expression = "{()}[]";
            check_balanced (expression);
      }
}
