package DynamicProgramming.longest_common_subsequence;

import java.util.Scanner;

//Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
public class Q2_Longest_common_substring_ {
      static int max = 0;
      public static int recursive_methode(String str1, String str2, int n, int m){
            if(n == 0 || m == 0){
                  return 0;
            }

            if(str1.charAt(n-1) == str2.charAt(m-1)){
                  return recursive_methode (str1, str2, n-1, m-1) + 1;
            }else{
                  return recursive_methode (str1, str2, n-1, m-1);
            }
      }

      public static int top_down_methode(String str1, String str2){
            int n = str1.length();
            int m = str2.length();
            int[][] dp = new int[n][m];
            int result = 0;
            for(int i = 0; i < dp.length; i++){
                  for(int j = 0; j < dp[0].length; j++){
                        if(i == 0 || j == 0){
                              dp[i][j] = 0;
                              continue;
                        }
                        if(str1.charAt(i-1) == str2.charAt(j-1)){
                              dp[i][j] = dp[i-1][j-1] + 1;
                              result = Math.max(dp[i][j] , result);
                        }else{
                              dp[i][j] = 0;
                        }
                  }
            }
            return result;

      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
             String x = "GeeksforGeeks";
             String y = "GeeksQuiz";

             //recursive
            int result = recursive_methode (x, y, x.length(), y.length());
            System.out.println("Output : "+max);

            //top down methode
            int result2 = top_down_methode (x, y);
            System.out.println("Output : "+result2);
      }
}
