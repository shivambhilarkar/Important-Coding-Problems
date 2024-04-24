package OA;

import java.util.ArrayDeque;
import java.util.Queue;

//get minimum distance till the treasure from multiple starting points.
public class Q_16_Treasure_Island {


    public static int getMinimumDistance(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'S') {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int distance = 0;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (queue.isEmpty() == false) {
            int size = queue.size();
            distance += 1;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 'O') {
                        continue;
                    }
                    if (grid[x][y] == 'X') {
                        return distance;
                    }
                    grid[x][y] = 'D';
                    queue.add(new int[]{x, y});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}
        };

        int result = getMinimumDistance(matrix);
        System.out.println("Result : "+ result);
    }
}
