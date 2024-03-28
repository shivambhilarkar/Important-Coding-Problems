
package Greedy_Algorithms;

import java.util.Arrays;

public class Q2_Minimum_number_of_platforms {


    public int findPlatforms(int[] arriavalTime, int[] deptTime, int n){
        if(n == 0) return 0;

        // ascending sort
        Arrays.sort(arriavalTime);
        Arrays.sort(deptTime);

        int platforms_needed = 0;
        int result = 1;

        int next_arrival = 1;
        int prev_dept = 0;

        while(next_arrival < n && prev_dept < n){

            if(arriavalTime[next_arrival] <= deptTime[prev_dept]){
                platforms_needed += 1;
                next_arrival += 1;
            }else{
                platforms_needed -= 1;
                prev_dept += 1;
            }
            result = Math.max(result, platforms_needed);
        }
        return result;
    }


    public static void main(String[] args) {
        
    }

}