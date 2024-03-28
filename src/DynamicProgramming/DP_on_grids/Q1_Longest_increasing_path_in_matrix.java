package DynamicProgramming.DP_on_grids;

public class Q1_Longest_increasing_path_in_matrix {


    public int getLongestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] cache = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int path = dfs(matrix, i, j, cache);
                max = Math.max(max, path);
            }
        }
        return max;
    }

    //array to store four directions
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    //depth first search
    public int dfs(int[][] grid, int i, int j, int[][] cache) {
        if(cache[i][j] != 0){
            return cache[i][j];
        }

        int max = 1; //current is start point
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x < 0 || x>= grid.length || y < 0 || y >= grid[0].length){
                continue;
            }
            int length = dfs(grid, x, y, cache) + 1;
            max = Math.max(max, length);
        }
        cache[i][j] = max;
        return max;
    }


    public static void main(String[] args) {

    }
}
