package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Q1_Minimum_number_of_arrows_to_burst_ballons {

    class comp implements Comparator<int[]> {

        @Override
        public int compare(int[] act1, int[] act2) {
            return Integer.compare(act1[1], act2[1]);
        }
    }

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new comp());

        long last = Long.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            if (last < points[i][0]) {
                count += 1;
                last = points[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
