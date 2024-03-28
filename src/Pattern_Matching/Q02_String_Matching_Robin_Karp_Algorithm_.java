package Pattern_Matching;

import java.util.Scanner;
//Robin-Karp Algorithm.
public class Q02_String_Matching_Robin_Karp_Algorithm_ {
      public static void match_Pattern(String text, String pattern){
            char[] txt = text.toCharArray();
            char[] pattrn = pattern.toCharArray();

            int n = text.length();
            int m = pattern.length();

            if(m == 0 || m > n){
                  System.out.println("Not Found");
                  return;
            }
            int powm = 1;
            int prime = 101;
            for(int i = 0; i < m-1; i++){
                  powm = (powm << 1) % prime;
            }
            int textHash = 0;
            int patternHash = 0;
//            hashcode for length m
            for(int i = 0; i < m; i++){
                  patternHash = ((patternHash << 1) + pattrn[i]) % prime;
                  textHash = ((textHash << 1) + txt[i]) % prime;
            }
//
            for(int i = 0; i <= (n-m); i++){
                  if(textHash == patternHash){
                        int j = 0;
                        while(j < m){
                              if(txt[i+j] != pattrn[j]){
                                    break;
                              }
                              j++;
                        }
                        if(j == m){
                              System.out.println("Pattern Found at index "+i);
                              return;
                        }
                  }
                  textHash = (((textHash - txt[i] * powm) << 1) + txt[i+m] ) % prime;
                  if(textHash < 0){
                        textHash = (textHash + prime);
                  }
            }
            System.out.println("Pattern Not Found...");
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String text = "shivambhilarkar";
            String pattern = "bhilar";
            match_Pattern (text, pattern);
      }
}
