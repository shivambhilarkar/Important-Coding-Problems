package Heap_Priority_Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q_6_Maximum_Average_Pass_Ratio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {


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

    public static void main(String[] args) {

    }
}
