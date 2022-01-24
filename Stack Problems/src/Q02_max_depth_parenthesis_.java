import java.util.Scanner;
//Given a balanced parenthesis expression we have to find maximum depth of parenthesis.
public class Q02_max_depth_parenthesis_ {
      public static void max_depth_(String expression){

            int curr_depth = 0;
            int max_depth = 0;
            for(char ch : expression.toCharArray ()){
                  if(ch == '('){
                        curr_depth += 1;
                  }else if(ch == ')'){
                        curr_depth -= 1;
                  }
                  max_depth = Math.max(curr_depth, max_depth);
            }
            System.out.println("Depth : "+max_depth);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            String expression = "((((A)))((((BBB()))))()())";
            max_depth_ (expression);
      }
}
