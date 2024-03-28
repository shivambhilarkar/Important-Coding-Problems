package Binary_Search.Set_2;

import java.util.Scanner;

public class Q02_Find_Peak_element_singlePeak {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            if (arr.length == 0 || arr.length == 1) {
                return 0;
            }

            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid == 0) { // if mid at 0 index ----> Edge cases
                    if (arr[mid] > arr[mid + 1]) {
                        return mid;
                    } else {
                        return mid + 1;
                    }
                } else if (mid == arr.length - 1) { // if mid at last index ----> Edge cases
                    if (arr[mid] > arr[mid - 1]) {
                        return mid;
                    } else {
                        return mid - 1;
                    }
                } else {
                    // Modified Binary search
                    if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) { // check condition is satisfied or not
                        return mid;
                    } else if (arr[mid] < arr[mid + 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }
}
