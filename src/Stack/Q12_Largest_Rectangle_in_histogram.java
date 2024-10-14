package Stack;

import java.util.Stack;


//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class Q12_Largest_Rectangle_in_histogram {

    public int largestRectangle(int[] input){
        if(input == null || input.length == 0) return 0;

        //left bound
        Stack<Integer> stack = new Stack<>();
        int n = input.length;
        int[] leftLimit = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && input[i] <= input[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                leftLimit[i] = 0;
            }else{
                leftLimit[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        stack.clear();


        //right bound
        int[] rightLimit = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && input[i] <= input[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rightLimit[i] = n-1;
            }else{
                rightLimit[i] = stack.peek() - 1;
            }
            stack.push(i);

        }


        //calculate area
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int width = rightLimit[i] - leftLimit[i] + 1;
            int area = width * input[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }


    public static void main(String[] args) {

    }
}
