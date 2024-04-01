package Graphs.Algorithms;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Kahns_algorithm {

    public int[] toposort(List<List<Integer>> adj, int n){

        int[] topo = new int[n];
        int[] indegree = new int[n];
        for(int i =0; i < n; i++){
            for(Integer dest : adj.get(i)){
                indegree[dest]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int index = 0;
        int count = 0;
        while(queue.isEmpty() == false){
            Integer node = queue.poll();
            topo[index++] = node;
            count += 1;

            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        if(count == n){
            return topo;
        }else{
            System.out.println("Graph has cycle");
            return new int[]{};
        }


    }



    public static void main(String[] args) {

    }
}
