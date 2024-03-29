package Greedy_Algorithms;

import java.util.Arrays;

public class Q3_Maximum_units_on_truck_ship {

    public int maxUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> a[1] - b[1]);

        int value = 0;
        for (int[] box : boxTypes) {

            if (box[0] < truckSize) {
                value += box[0] * box[1];
            } else {
                value += truckSize * box[1];
                truckSize = 0;
                break;
            }
            truckSize = truckSize - box[0];
        }

        return value;
    }

    public static void main(String[] args) {

    }


}
