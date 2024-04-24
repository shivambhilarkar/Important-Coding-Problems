package Graphs.Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//note : list<list<int>> adj does time limit exceed
public class Q4_Minimum_Degree_of_a_Connected_Trio_in_a_Graph {

    public int minTrioDegree(int n, int[][] edges) {
        if (n == 0 || edges == null)
            return -1;

        List<Set<Integer>> adj = new ArrayList<>();

        int[] degree = new int[n];
        getDegreeOfGraphs(n, edges, adj, degree);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (adj.get(j).contains(i) == false) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (adj.get(k).contains(i) && adj.get(k).contains(j)) {
                        int minDegree = degree[i] + degree[j] + degree[k] - 6;
                        result = Math.min(minDegree, result);
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    private void getDegreeOfGraphs(int n, int[][] edges, List<Set<Integer>> adj, int[] degree) {
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        // convert to zero based indexing
        for (int[] edge : edges) {
            int src = edge[0] - 1;
            int dest = edge[1] - 1;

            degree[src] += 1;
            degree[dest] += 1;

            // add in graph
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
    }


}
