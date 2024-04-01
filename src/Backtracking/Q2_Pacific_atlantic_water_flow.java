package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_Pacific_atlantic_water_flow {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        int[][] fill = new int[matrix.length][matrix[0].length];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, fill, 1);
            dfs(matrix, i, matrix[0].length - 1, Integer.MIN_VALUE, fill, 2);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, fill, 1);
            dfs(matrix, i, matrix.length - 1, Integer.MIN_VALUE, fill, 2);
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (fill[i][j] == 3) {
                    List<Integer> list = Arrays.asList(i, j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] matrix, int i, int j, int parent, int[][] fill, int ocean) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }
        if (fill[i][j] == ocean || fill[i][j] == 3 || matrix[i][j] < parent) {
            return;
        }

        fill[i][j] += ocean;
        dfs(matrix, i + 1, j, matrix[i][j], fill, ocean);
        dfs(matrix, i - 1, j, matrix[i][j], fill, ocean);
        dfs(matrix, i, j + 1, matrix[i][j], fill, ocean);
        dfs(matrix, i, j - 1, matrix[i][j], fill, ocean);

    }


    public static void main(String[] args) {

    }

}
