package Graphs.Algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Bellman Ford Algorithm
 * 1.Single source - shortest path algorithm
 * 2.Used in to detect negative cycles from graph.
 * 3.Only applicable in directed graph.
 * <p>
 * How to solve for un-directed graph.
 * -> convert un-direct graph into direct graph and then solve it.
 * Relax all the edges (n-1) time sequentially
 */

public class Bellman_Ford_Algorithm {

    public int[] bellmanFord(int V, List<List<Integer>> edges, int source) {
        int[] distance = new int[V]; //initialize distance array with infinity
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // do relaxation for V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if (distance[u] != Integer.MAX_VALUE &&
                        distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }
        //nth relaxation to check negative cycle
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            if (distance[u] != Integer.MAX_VALUE &&
                    distance[u] + weight < distance[v]) {
                // add logic to return answer as graph has negative cycles
                int[] result = new int[1];
                result[0] = -1;
                return result;
            }
        }
        return distance;
    }

    public void get_shortest_distance_from_source_to_all_nodes(List<List<Integer>> edges, int nodes, int source) {
        int[] distance = bellmanFord(nodes, edges, source);
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Source:" + source + " -> " + i + " => " + distance[i]);
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
    }
}
