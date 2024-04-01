package Graphs.Questions;

import java.util.List;

public class Q2_Bridge_in_graph {

    public void printBridges(List<List<Integer>> adj, int n){
        int[] visited = new int[n];
        int[] timeOfInsertion = new int[n];
        int[] low = new int[n];

        int timer = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(i, -1, visited, timeOfInsertion, low, adj, timer);
            }
        }
    }

    public void dfs(int node, int parent, int[] visited, int[] timeOfInsertion
            , int[] low, List<List<Integer>> adj, int time){

        visited[node] = 1;
        timeOfInsertion[node] = low[node] = time;
        time += 1;

        for(Integer dest : adj.get(node)){

            if(dest == parent) continue;

            if(visited[dest] == 0){

                dfs(dest, node,visited, timeOfInsertion, low, adj, time);

                low[node] = Math.min(low[node], low[dest]);

                if(low[dest] >  timeOfInsertion[node]){
                    System.out.println(dest + " --> "+ node);
                }
            }else{
                low[node] = Math.min(low[node], timeOfInsertion[dest]);
            }
        }
    }
}
