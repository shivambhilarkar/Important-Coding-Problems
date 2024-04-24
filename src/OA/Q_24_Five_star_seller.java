package OA;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-average-pass-ratio/description/
public class Q_24_Five_star_seller {

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        //Important concept
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            double d0 = (double) (a[0] + 1) / (a[1] + 1) - (double) (a[0]) / a[1];
            double d1 = (double) (b[0] + 1) / (b[1] + 1) - (double) (b[0]) / b[1];
            if (d1 > d0) return 1;
            else return -1;
        });

        queue.addAll(Arrays.asList(classes));

        double sum = 0.0;
        while (extraStudents > 0 && queue.isEmpty() == false) {
            int[] entry = queue.poll();

            if (entry[0] == entry[1]) {
                sum += 1;
            } else {
                entry[0] += 1;
                entry[1] += 1;
                extraStudents -= 1;

                queue.add(entry);
            }
        }


        while (queue.isEmpty() == false) {
            int[] curr = queue.poll();
            sum += (double) curr[0] / curr[1];
        }
        return (sum / classes.length);
    }
}
