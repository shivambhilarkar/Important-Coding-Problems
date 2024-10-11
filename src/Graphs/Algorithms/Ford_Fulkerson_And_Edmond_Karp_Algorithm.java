package Graphs.Algorithms;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Ford Fulkerson Algorithm and Edmond Karp Algorithm
 * 1. used in calculating maximum flow in graph.
 *
 * Important :
 * Path-Finding Method:
 * Ford-Fulkerson can use any method (e.g., DFS or BFS) to find augmenting paths,
 * while Edmonds-Karp specifically uses BFS to ensure that the shortest path
 * (in terms of the number of edges) is always chosen.
 *
 * ford fulkerson -> uses dfs or bfs algorithm to find maximum flow.
 * edmond karp -> uses only bfs , such that it find shortest maximum flow.
 */


class FordFulkerson{
    class Graph{
        private int nodes; //number of vertices
        private int[][] capacity;

        public Graph(int v){
            this.nodes = v;
            capacity = new int[nodes][nodes];
        }
        public void addEdge(int u, int v, int cap){
            capacity[u][v] = cap; //add capacity from u to v
        }

        public int fordFulkerson(int source, int destination){
            int[] parent = new int[this.nodes];
            int maxFlow = 0;

            // Augment the flow while there is a path from source to destination
            while(bfs(source, destination, parent)){
                // find the maximum flow through the path found
                int pathFlow = Integer.MAX_VALUE;
                for(int v = destination; v != source; v = parent[v]){
                    int u = parent[v];
                    pathFlow = Math.min(pathFlow, capacity[u][v]);
                }

                // update residual capacities of the edges and reverse edges
                for(int v = destination; v != source; v = parent[v]){
                    int u = parent[v];
                    capacity[u][v] -= pathFlow;
                    capacity[v][u] += pathFlow;
                }

                // add path flow to overall flow
                maxFlow += pathFlow;
            }
            return maxFlow;
        }
        public boolean bfs(int source, int destination, int[] parent) {
            boolean[] visited = new boolean[this.nodes];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            visited[source] = true;
            parent[source] = -1;

            // bfs for adj matrix representation
            while (queue.isEmpty() == false) {
                int u = queue.poll();
                for (int v = 0; v < this.nodes; v++) {
                    if (visited[v] == false && capacity[u][v] > 0) {
                        queue.add(v);
                        visited[v] = true;
                        parent[v] = u;
                    }
                }
            }
            // return true if we reached the sink
            return visited[destination];
        }
    }

    // Function to perform DFS and find an augmenting path
    private boolean dfs(int[][] capacity, int[] parent, int source, int sink, boolean[] visited) {
        visited[source] = true;

        if (source == sink) {
            return true; // If we reached the sink, we found an augmenting path
        }

        for (int v = 0; v < capacity.length; v++) {
            // If not visited and there's remaining capacity
            if (!visited[v] && capacity[source][v] > 0) {
                parent[v] = source; // Track the path
                if (dfs(capacity, parent, v, sink, visited)) {
                    return true; // Found a path to sink
                }
            }
        }
        return false; // No path found
    }


}


public class Ford_Fulkerson_And_Edmond_Karp_Algorithm {


}
