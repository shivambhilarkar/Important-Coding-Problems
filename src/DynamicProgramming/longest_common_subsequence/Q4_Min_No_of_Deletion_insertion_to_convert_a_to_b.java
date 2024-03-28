package DynamicProgramming.longest_common_subsequence;

import java.util.Scanner;

public class Q4_Min_No_of_Deletion_insertion_to_convert_a_to_b {
      public static int recursive(String str1, String str2, int n, int m){
            if(n == 0 || m == 0){
                  return 0;
            }

            if(str1.charAt(n-1) == str2.charAt(m-1)){
                  return recursive (str1, str2, n-1, m-1) + 1;
            }else{
                  return Math.max(recursive (str1, str2, n-1, m) ,
                                  recursive (str1, str2, n, m-1));
            }
      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            String a = "heap";
            String b = "pea";

            //heap -> eap -> ea -> pea ;
            //2 deletion & 1 insertion = total 3
            //no of deletion = aString - common(a,b)
            //no of insertion = bString - common(a,b)

            int lcs = recursive (a, b, a.length(), b.length());
            int no_of_deletion = a.length() - lcs;
            int no_of_insertion = b.length() - lcs;
            int total = no_of_deletion + no_of_insertion;
            System.out.println("Output : "+ total);

      }
}
