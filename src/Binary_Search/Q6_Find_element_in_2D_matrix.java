package Binary_Search;

import java.util.Scanner;

//Given 2D row wise sorted matrix.
//search element in that using binary search.
public class Q6_Find_element_in_2D_matrix {

      public static void search_Matrix(int[][] matrix , int searchValue){
            int row = 0;
            int col = matrix[0].length-1;

            while(row < matrix.length && col >= 0){
                  if(matrix[row][col] == searchValue){
                        System.out.println("Element Found");
                        return;
                  }else if(matrix[row][col] < searchValue){
                        row += 1;
                  }else{
                        col -= 1;
                  }
            }
            System.out.println("Element Not found.");
      }

      public static void main(String[] arg){
            Scanner scan = new Scanner(System.in);
            int[][] matrix = { {1,2,3} , {4,5,6} ,{7,8,9}};
            search_Matrix (matrix , 7);
            search_Matrix (matrix, 11);
      }
}
