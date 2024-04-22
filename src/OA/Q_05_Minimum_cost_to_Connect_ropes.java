package OA;

import java.util.PriorityQueue;

public class Q_05_Minimum_cost_to_Connect_ropes {

    public static int getMinimumCost(int[] items){

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int item : items){
            queue.add(item);
        }

        int result = 0;
        while(queue.size() > 1){
            int top1 = queue.poll();
            int top2 = queue.poll();
            result += (top1 + top2);

            queue.add(top1 + top2);
        }
        return result;

    }


    public static void main(String[] args) {

        int[] ropes = {8, 4, 6, 12};

        //answer = 58
        int result = getMinimumCost(ropes);
        System.out.println("Result : "+ result);
    }
}
