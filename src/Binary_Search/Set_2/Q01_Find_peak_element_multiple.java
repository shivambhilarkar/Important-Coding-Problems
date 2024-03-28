package Binary_Search.Set_2;

import java.util.Scanner;

class Q01_Find_peak_element_multiple {

    class Solution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 0)
                return 0;
            if (nums.length == 1)
                return 0;
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid == 0) { // if mid at 0 index ---> edge case
                    if (nums[mid] > nums[mid + 1]) {
                        return mid;
                    } else {
                        return mid + 1;
                    }
                } else if (mid == nums.length - 1) { // if mid at last index ----> edge case
                    if (nums[mid] > nums[mid - 1]) {
                        return mid;
                    } else {
                        return mid - 1;
                    }
                } else {
                    // ---------------> Normal Modified Binary Search
                    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // check condition is satisfied
                        return mid;
                    } else if (nums[mid] < nums[mid + 1] && nums[mid - 1] < nums[mid]) {
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