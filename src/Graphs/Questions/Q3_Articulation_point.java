package Graphs.Questions;

import java.util.List;

public class Q3_Articulation_point {

    public void printArticulationPoint(List<List<Integer>> adj, int n) {

        int[] visited = new int[n];
        int[] timeOfInsertion = new int[n];
        int[] low = new int[n];

        int[] articulations = new int[n];
        int timer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, visited, timeOfInsertion, low, adj, timer, articulations);
            }
        }

        for (int i = 0; i < n; i++) {
            if (articulations[i] == 1) {
                System.out.println("Articulation Point : " + i);
            }
        }
    }

    private void dfs(int node, int parent, int[] visited, int[] timeOfInsertion,
                     int[] low, List<List<Integer>> adj, int time, int[] articulations) {

        visited[node] = 1;
        timeOfInsertion[node] = low[node] = time;
        time += 1;
        int child = 0;
        for (int nbr : adj.get(node)) {

            if (nbr == parent) continue;

            if (visited[nbr] == 0) {
                dfs(nbr, node, visited, timeOfInsertion, low, adj, time, articulations);

                low[node] = Math.min(low[node], low[nbr]);

                if (low[nbr] >= timeOfInsertion[node] && parent != -1) {
                    articulations[node] = 1;
                }
                child += 1;
            } else {
                low[node] = Math.min(low[node], timeOfInsertion[nbr]);
            }
        }
        if(parent != -1 && child > 1){
            articulations[node] = 1;
        }

    }


    public static void main(String[] args) {

    }
}
