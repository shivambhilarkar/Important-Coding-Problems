package Graphs.Questions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/critical-connections-in-a-network/
public class Q5_Critical_Connections {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // create graph from connections
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int src = connection.get(0);
            int dest = connection.get(1);
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        int[] timeOfInsertion = new int[n];
        int[] lowestTime = new int[n];
        int[] visited = new int[n];
        List<List<Integer>> result = new ArrayList<>();

        int timer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, timeOfInsertion, lowestTime, timer, visited, adj, result);
            }
        }
        return result;
    }

    public void dfs(int node, int parent, int[] timeOfInsertion, int[] lowestTime, int timer, int[] visited,
                    List<List<Integer>> adj, List<List<Integer>> result) {

        visited[node] = 1; // visited
        timeOfInsertion[node] = lowestTime[node] = timer; // set time
        timer += 1; // increment timer

        for (Integer nbr : adj.get(node)) {

            if (nbr == parent)
                continue;// dont go to parent

            // if nbr is not visited
            if (visited[nbr] == 0) {

                dfs(nbr, node, timeOfInsertion, lowestTime, timer, visited, adj, result);

                lowestTime[node] = Math.min(lowestTime[node], lowestTime[nbr]);

                // lowestTime of nbr is greater than timeOfInsertion of current node then
                if (lowestTime[nbr] > timeOfInsertion[node]) {
                    // this is a critical connection
                    result.add(Arrays.asList(nbr, node));
                }

            } else {
                // if nbr is already visited, get the lowestTime from them
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[nbr]);
            }

        }

    }

}
