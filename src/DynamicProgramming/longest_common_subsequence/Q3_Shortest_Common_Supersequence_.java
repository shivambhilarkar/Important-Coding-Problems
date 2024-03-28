package DynamicProgramming.longest_common_subsequence;

import java.util.Scanner;

public class Q3_Shortest_Common_Supersequence_ {
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
                              dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                        }
                  }
            }
            int lcs = dp[n][m]; //common part
            int supersequnce = str1.length() + str2.length() - lcs;
            return supersequnce;
      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            String x = "geek";
            String y = "eke";

            //supersequence mean character from both string should appear in one string.
            // geek + eke = geekeke
            //but shortest seq is = geeke --> geek , eke
            //supersequence = string1 + string2
            //supersequcne = string1Uncommon + String2Uncommon - common(str1, str2)

            int result = top_down_methode(x, y);
            System.out.println("Output : "+ result);
      }
}
