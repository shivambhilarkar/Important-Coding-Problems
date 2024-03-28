package Binary_Search.Set_2;

import java.util.Scanner;

/*
IMPORTANT : ---> Rotated sorted array property
If we split a rotated sorted array in half, one half is monotonic-increasing,
the other half itself is a rotated sorted array.
We can compare the start and end element in a half to tell whether it is monotonic-increasing.

To search for an element in rotated sorted array,
    1. -> Divide rotated sorted array in half,
    2. -> If target in monotonic-increasing half, do Binary Search;
            Otherwise, re-apply the first step on the other half

*/

public class Q03_Search_in_rotated_sorted_array {

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[mid] < nums[right]) {// right half is sorted
                    if (nums[mid] < target && target <= nums[right]) { // target within right half
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {// left half is sorted
                    if (nums[left] <= target && nums[mid] > target) { // target within left half
                        right = mid - 1;
                    } else {
                        left = mid + 1;
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
