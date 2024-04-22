package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given 2 lists a and b.
 * Each element is a pair of integers where the first integer represents the unique id and
 * the second integer represents a value.
 * Your task is to find an element from a and an element form b such that
 * the sum of their values is less or equal to target and as close to target as possible.
 * Return a list of ids of selected elements. If no pair is possible, return an empty list.
 * --------------------------
 * Input:
 * a = [[1, 2], [2, 4], [3, 6]]
 * b = [[1, 2]]
 * target = 7
 * --------------------------
 * Output: [[2, 1]]
 * Explanation:
 * There are only three combinations [1, 1], [2, 1], and [3, 1],
 * which have a total sum of 4, 6 and 8, respectively.
 * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 */
public class Q_04_Optimal_Utilization {

    public static int[] findElement(int[][] array, int target) {
        int length = array.length;
        int start = 0;
        int end = length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid][1] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return array[start];
    }


    public static List<int[]> getOptimalUtilization(int[][] a, int[][] b, int target) {

        //sort both arrays ascending
        Arrays.sort(a, (a1, a2) -> a1[1] - a2[1]);
        Arrays.sort(b, (b1, b2) -> b1[1] - b2[1]);

        int len1 = a.length;
        int len2 = b.length;

        int currentValue = 0;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int[] current = a[i];
            int[] next = findElement(b, target - current[1]);

            if (current[1] + next[1] <= target) {
                if (currentValue <= current[1] + next[1]) {
                    result.clear();
                    result.add(new int[]{current[0], next[0]});
                } else if (current[1] + next[1] == currentValue) {
                    result.add(new int[]{current[0], next[0]});
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[][] a = {{1, 2}, {2, 4}, {3, 6}};
        int[][] b = {{1, 2}};
        int target = 7;

        List<int[]> result = getOptimalUtilization(a,b, target);
        System.out.print("Result : ");
        for(int[] e : result){
            System.out.print(Arrays.toString(e) + " , ");
        }
    }
}
