package DynamicProgramming.longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_Russian_Doll_Envelops_ {

      public static void maximumEnvelopes(int[][] envelopes){
            int n = envelopes.length;
            Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
            int[] dp = new int[n];
            int oMax = 0;
            for(int i = 0; i < envelopes.length; i++){
                  int max = 0;
                  for(int j = 0; j < i; j++){
                        if(envelopes[j][1] < envelopes[i][1] &&
                            envelopes[j][0] < envelopes[i][0]){
                              if(dp[j] > max){
                                    max = dp[j];
                              }
                        }
                  }
                  dp[i] = max + 1;
                  if(dp[i] > oMax){
                        oMax = dp[i];
                  }
            }
            System.out.println("Result : "+oMax);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
//            int[][] envelopes =  [[5,4],[6,4],[6,7],[2,3]];
//            weight & height
//            Output: 3 Explanation:The maximum number of envelopes you can
//            Russian doll is 3 ([2,3] => [5,4] => [6,7]).
            int[][] envelopes = { {5,4},{6,4},{6,7},{2,3}};
            maximumEnvelopes (envelopes);

      }
}
