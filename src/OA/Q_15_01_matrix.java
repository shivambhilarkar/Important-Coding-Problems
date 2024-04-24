package OA;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q_15_01_matrix {

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int distance = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();

            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];

                if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[current[0]][current[1]] >= mat[x][y]) {
                    continue;
                }
                queue.add(new int[]{x, y});
                mat[x][y] = mat[current[0]][current[1]] + 1;
            }
        }
        return mat;


    }

    public static void main(String[] args) {

    }
}
