package DynamicProgramming.longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Q4_Maximum_non_overlapping_bridges_building {
      public static void top_down_methode(int[][] brideges){
            int n = brideges.length;
            //sort bridges on north position.
            Arrays.sort (brideges,(a,b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
            int[] dp = new int[n];
            int oMax = 0;
            for(int i = 0; i < dp.length; i++){
                  int max = 0;
                  for(int j = 0; j < i; j++){
                        if(brideges[j][0] < brideges[i][0]){
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
            System.out.println("Bridges : "+ oMax);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
//            Input : 8 1 4 3 5 2 6 7
//                    1 2 3 4 5 6 7 8
//            Output : Maximum number of bridges = 5

            int[] south = {8,1,4,3,5,2,6,7};
            int[] north = {1,2,3,4,5,6,7,8};
            int n = south.length;

            int[][] bridges = new int[n][2];
            for(int i = 0; i < n; i++){
                  bridges[i] = new int[] { south[i], north[i]};
            }
            top_down_methode (bridges);

      }

}
