package Stack;

import java.util.Stack;

public class Q11_Asteroid_Collision {

    public int[] asteroids(int[] asteroids){

        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            if(asteroid > 0){
                stack.push(asteroid);
            }else{

                while(!stack.isEmpty() && stack.peek() > 0 &&
                   Math.abs(asteroid) > stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroid);
                }else if(stack.peek() == Math.abs(asteroid)){
                    stack.pop();
                }
            }
        }

        /**
         * pop all elements from stack and return answer as array.
         */
        int[] result = new int[stack.size()];
        int index = result.length - 1;
        while(!stack.isEmpty()){
            result[index--] = stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
