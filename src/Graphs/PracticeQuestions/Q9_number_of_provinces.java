package Graphs.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/number-of-provinces/
also try union find approach
 */

public class Q9_number_of_provinces {
    class Solution {
        class Graph {
            List<List<Integer>> adj;
            int nodes;

            Graph(int nodes) {
                this.nodes = nodes;
                this.adj = new ArrayList<>();
                for (int i = 0; i < nodes; i++) {
                    this.adj.add(new ArrayList<>());
                }
            }

            public void addUnDirectedEdge(int src, int dest) {
                this.adj.get(src).add(dest);
                this.adj.get(dest).add(src);
            }
        }

        public int findCircleNum(int[][] isConnected) {
            int nodes = isConnected.length;
            Graph graph = new Graph(isConnected.length);
            //add edges to graph
            for (int i = 0; i < isConnected.length; i++) {
                for (int j = i; j < isConnected.length; j++) {
                    if (i != j && isConnected[i][j] != 0) {
                        graph.addUnDirectedEdge(i, j);
                    }
                }
            }

            boolean[] visited = new boolean[nodes];
            int count = 0;
            //dfs for all nodes and count connected components
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == false) {
                    dfs(i, graph, visited);
                    count += 1;
                }
            }
            return count;
        }

        public void dfs(int src, Graph graph, boolean[] visited) {
            visited[src] = true;
            for (int nbr : graph.adj.get(src)) {
                if (visited[nbr] == false) {
                    dfs(nbr, graph, visited);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
