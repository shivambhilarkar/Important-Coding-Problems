import java.util.Scanner;

//Search a Pattern in a given text.
public class Q01_String_Pattern_Matching_Brute_force_{
      public static void search_pattern(String text, String pattern){
            int n = text.length();
            int m = pattern.length();

            int i = 0;
            while(i <= n - m){
                  int j = 0;
                  //checking pattern
                  while(j < m && text.charAt(i+j) == pattern.charAt(j)){
                        j++;
                  }
                  if( j == m){ //if j goes to pattern.length() then we have found pattern
                        System.out.println("Pattern Found at index "+i + " to "+(i+m-1));
                        return;
                  }
                  i += 1;
            }
            System.out.println("Pattern Not Found...");
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String text = "shivambhilarkar";
            String pattern = "bhilar";
            search_pattern (text, pattern);
      }
}
