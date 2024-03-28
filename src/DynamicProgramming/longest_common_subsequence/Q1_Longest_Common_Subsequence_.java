package DynamicProgramming.longest_common_subsequence;

import java.util.Scanner;

public class Q1_Longest_Common_Subsequence_ {
      public static int recursive_methode(String str1, String str2, int n, int m){
            if(n == 0 || m == 0){
                  return 0;
            }
            if(str1.charAt(n-1) == str2.charAt (m-1)){
                  //both char are equal
                  return recursive_methode (str1, str2, n-1, m-1) + 1;
            }else{
                  //check for one char exclude in both string
                  return Math.max( recursive_methode (str1, str2, n-1, m),
                                   recursive_methode (str1, str2, n, m-1));
            }
      }

      public static int top_down_methode(String str1, String str2){
            int n = str1.length();
            int m = str2.length();
            int[][] dp = new int[n+1][m+1];
            for(int i = 0; i < dp.length; i++){
                  for(int j = 0; j < dp[0].length; j++){
                        if(i == 0 || j == 0){
                              dp[i][j] = 0;
                              continue;
                        }
                        if(str1.charAt(i-1) == str2.charAt(j-1)){
                              dp[i][j] = dp[i-1][j-1] + 1;
                        }else{
                              dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                        }
                  }
            }
            return dp[n][m];
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            String str = "abcde";
            String str2 = "ace";

            //recursive
            int result = recursive_methode (str, str2, str.length(), str2.length());
            System.out.println("Output : "+result);

            //top down methode
            int result2 = top_down_methode (str, str2);
            System.out.println("Output : "+result2);
      }
}
