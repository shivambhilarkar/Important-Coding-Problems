package OA;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/prison-cells-after-n-days/
public class Q_26_Prison_cells_after_n_days {

//-------------------- Brute Force ----------------------------------------
        public int[] prisonAfterDay(int[] cells) {
            if (cells == null || cells.length == 0) return cells;

            int[] result = new int[cells.length];


            int[] row = cells;
            result[0] = 0;
            result[row.length - 1] = 0;

            for (int i = 1; i < row.length - 1; i++) {
                if (row[i - 1] == 1 && row[i + 1] == 1) {
                    result[i] = 1;
                } else if (row[i - 1] == 0 && row[i + 1] == 0) {
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            }
            return result;
        }

        public int[] prisonAfterNDays(int[] cells, int n) {


            int[] result = cells;
            // System.out.println(Arrays.toString(cells));
            while (n-- > 0) {
                result = prisonAfterDay(result);
                // System.out.println(Arrays.toString(result));
            }
            return result;
        }

//        -------------------------------------------------------------------------------------------------------
//    Optimal Strategy


    public int[] prisonAfterNDays2(int[] arr, int n) {


        HashMap<String,Integer> hp = new HashMap<>();

        while (n > 0) {
            int[] a = new int[8];
            hp.put(Arrays.toString(arr),n--);

            for (int i = 1; i < 7; ++i)
                if(arr[i-1]==arr[i+1]) a[i] = 1;
                else a[i] = 0;
            arr = a;
            if (hp.containsKey(Arrays.toString(arr))) {
                n %= hp.get(Arrays.toString(arr)) - n;
            }
        }
        return arr;
    }


}
