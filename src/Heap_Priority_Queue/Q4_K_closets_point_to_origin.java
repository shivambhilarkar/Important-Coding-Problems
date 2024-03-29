package Heap_Priority_Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q4_K_closets_point_to_origin {

    public int[][] getKClosetsPoints(int[][] points, int k) {

        /**
         * formula to calculate distance between two points
         * √[(x2 − x1)2 + (y2 − y1)2]
         */
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) ->
                (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));

        for (int[] point : points) {
            queue.add(point);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            k -= 1;
            result[k] = queue.poll();
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
