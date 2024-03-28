package DynamicProgramming.longest_common_subsequence;

import java.util.Scanner;

//1.min no of insertion to make string palindromic.
//2.min no of deletion to make string palindromic.
//3.min no of insertion & deletion to make string palindromic.
public class Q6_Min_No_of_del_insert_operation_to_make_palindromic {
//      public static int recursive(String str, String revstr){
//
//            //
//      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            String str = "agbcba";

            //1.deletion -> if we delete g then string -> abcba
            //i.e is equal to longest palindromic sequence.

            //2.insertion -> if we insert g then string -> agbcbga
            //i.e is equal to longest palindromic sequence.

            //formula ;
            //find longest palindromic seq & subtract it from original string len
            //then we get min operation count;
      }
}
