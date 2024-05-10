package Binary_Search.Set_3;

import java.util.Arrays;

//https://leetcode.com/problems/magnetic-force-between-two-balls/description/
public class Q03_Aggressive_cows {

    class Solution {
        public int solve(int n, int k, int[] stalls) {
            if (stalls == null || stalls.length == 0) {
                return 0;
            }

            Arrays.sort(stalls);

            int low = 1;
            int high = stalls[n - 1] - stalls[0];
            int result = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (canPlace(stalls, mid, k)) {
                    low = mid + 1;
                    result = mid;
                } else {
                    high = mid - 1;
                }
            }
            return result;
        }

        public boolean canPlace(int[] stalls, int distance, int cows) {
            int cowsPlaced = 1;
            int last = stalls[0];
            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - last >= distance) {
                    cowsPlaced += 1;
                    last = stalls[i];
                }
                if (cowsPlaced >= cows) {
                    return true;
                }
            }
            return false;

        }
    }

    public static void main(String[] args) {

    }
}
