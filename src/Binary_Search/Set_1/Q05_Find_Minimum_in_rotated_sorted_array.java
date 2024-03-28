package Binary_Search.Set_1;

import java.util.Scanner;

public class Q05_Find_Minimum_in_rotated_sorted_array {

      public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            if(nums.length == 0) return 0;
            if(nums.length == 1) return nums[0];

            while(left < right ){
                  int mid = left + (right - left) / 2;
                  if(nums[mid] < nums[right]){
                        right = mid;
                  }else{
                        left = mid + 1;
                  }
            }
            return nums[left];
      }
      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
      }
}
