package Greedy_Algorithms;

public class Q3_Gas_stations {

    /**
     * return starting index , such that we can travel through all the gas stations
     */

    public int canTravel(int[] gas, int[] cost){
        int n = gas.length;
        int currentGas = 0;
        for(int i = 0; i < n; i++){
            currentGas += (gas[i] - cost[i]);
        }
        //not possible
        if(currentGas < 0) return -1;

        int averageGas = 0;
        int index = 0;
        for(int i = 0; i < n; i++){
            averageGas += (gas[i] - cost[i]);
            if(averageGas < 0){
                index = i + 1;
                averageGas = 0;
            }
        }

        return index;
    }


    public static void main(String[] args) {
        
    }
    
}