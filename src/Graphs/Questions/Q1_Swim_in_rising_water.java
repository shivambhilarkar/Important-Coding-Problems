package Graphs.Questions;

import java.util.PriorityQueue;

public class Q1_Swim_in_rising_water {

    public int swimInRisingWater(int[][] grid){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> grid[a[0]][b[0]] - grid[b[0]][b[1]]);
        queue.add(new int[]{ 0 , 0});

        int level = 0;
        int n = grid.length;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[n][n];

        while(queue.isEmpty() == false){

            int[] top = queue.poll();
            level = Math.max(level, grid[top[0]][top[1]]);

            if(top[0] == n-1 && top[1] == n-1){
                break;
            }

            for(int[] direction : directions){
                int x = top[0] + direction[0];
                int y = top[1] + direction[1];

                if( !(x < 0 || x >= n-1 || y < 0 || y >= n-1) && (!visited[x][y])){
                    visited[top[0]][top[1]] = true;
                    queue.add(new int[]{ x ,y});
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {

    }
}
