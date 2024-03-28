package DynamicProgramming.fibonaci_numbers;

import java.util.Scanner;

public class Q1_Fibonaci_Numbers_ {
      public static int fibonaci(int n){
            if(n == 0){
                  return 0;
            }else if(n == 1){
                  return 1;
            }else if(n == 2){
                  return 1;
            }

            return (fibonaci (n-1) + fibonaci (n-2));

      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int n = 5;
            //1 - 1
            //2 - 1
            //3 - 2
            //4 - 3
            //5 - 5
            //6 - 8
            //7 - 13
            int result = fibonaci (7);
            System.out.println (result);
      }
}
