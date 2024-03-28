package DynamicProgramming.knapsack_problem_0_1;

import java.util.Scanner;

//Given a non-empty array nums containing only positive integers,
// find if the array can be partitioned into two subsets such that
// the sum of elements in both subsets is equal.
public class Q3_Equal_sum_partition_ {
      public static boolean find_equal_subset(int[] nums, int sum, int n){
            if(sum == 0){
                  return true;
            }else if(n == 0){
                  return false;
            }
            if(nums[n-1] <= sum){
                  //included or excluded current item.
                  return find_equal_subset (nums, sum - nums[n-1], n-1) ||
                          find_equal_subset (nums, sum, n-1);
            }else{
                  //excluded current item.
                  return find_equal_subset (nums, sum, n-1);
            }
      }



      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);
            int[] nums = {1,5,11,5};
            //output : true;
            // The array can be partitioned as [1, 5, 5] and [11].
            int n = nums.length;
            int sum = 0;
            for(int num : nums){
                  sum += num;
            }

            if(sum%2 != 0){
                  System.out.println(false);
//                  return false;
            }else{
                  boolean result = find_equal_subset(nums, sum/2 , n);
                  System.out.println(result);
            }


            //take sum of all numbers.
            //if sum is odd then we cannot divide in two equal parts..so answer = false
            //if sum if even then we have to find sum / 2 in array..
            //if we find sum/2 then remaining is also sum/2
            //sum/2 + sum/2 == sum hence we can partition the array.
            //else return false we can't find sum/2

            //same as subset sum problem.

      }


}
