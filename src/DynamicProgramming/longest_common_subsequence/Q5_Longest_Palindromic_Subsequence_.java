package DynamicProgramming.longest_common_subsequence;

import java.util.Scanner;

public class Q5_Longest_Palindromic_Subsequence_ {
      public static int recursive(String str, String revstr, int n , int m){
            if(n == 0 || m == 0){
                  return 0;
            }
            if(str.charAt(n-1) == revstr.charAt(m-1)){
                  return recursive (str, revstr, n-1, m-1) + 1;
            }else{
                  return Math.max (recursive (str, revstr, n-1, m) ,
                                   recursive (str, revstr, n, m-1));
            }
      }
      public static String revstring(String str){
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            String str = "agbcba";
            // answer -> abcba -> 5
            //if we find longest common subsequence of str & rev(str)
            //agbcba & abcbga -> abcba i.e equal to longest palindromic.
            String revstr = revstring(str);
            int result = recursive (str, revstr, str.length(), revstr.length());
            System.out.println("Output : "+result);
      }
}
