package Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//given an expression , number each parenthesis pair such that for each pair the
//opening and closing parenthesis have same number.

public class Q05_print_Parenthesis_Number_ {
      public static void print_parenthesis_number(String expression){
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> indexs = new ArrayList<>();
            int index = 0;
            for(int i = 0; i < expression.length (); i++){
                  char ch = expression.charAt(i);
                  if(ch == '('){
                        index += 1;
                        stack.push (index);
                        indexs.add(index);
                  }else if(ch == ')'){
                        indexs.add(stack.pop());
                  }
            }
            System.out.println("Parenthesis Index : "+indexs);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            String expression = "(((a+(b))+(c+d)))";
            print_parenthesis_number (expression);

      }
}
