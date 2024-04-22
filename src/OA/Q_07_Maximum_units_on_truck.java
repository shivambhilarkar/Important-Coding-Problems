package OA;

import java.util.Arrays;

public class Q_07_Maximum_units_on_truck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        //sort Array Ascending
        Arrays.sort(boxTypes, (box1, box2) -> box2[1] - box1[1]);

        int units = 0;
        for (int[] box : boxTypes) {

            if (box[0] < truckSize) {
                units += (box[0] * box[1]);
            } else {
                units += (truckSize * box[1]);
                truckSize = 0;
                break;
            }
            truckSize -= box[0];
        }
        return units;
    }

    public static void main(String[] args) {

    }
}
