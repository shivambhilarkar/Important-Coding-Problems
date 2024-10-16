package Graphs.Algorithms;

import java.util.Arrays;

public class FloydWarshall {

      static final int INF = Integer.MAX_VALUE; // Use a large value to represent infinity

      public static void floydWarshall(int[][] graph) {
            int vertices = graph.length;
            // Distance array
            int[][] dist = new int[vertices][vertices];

            // Initialize the distance array with graph values
            for (int i = 0; i < vertices; i++) {
                  for (int j = 0; j < vertices; j++) {
                        if (i == j) {
                              dist[i][j] = 0; // Distance to self is zero
                        } else if (graph[i][j] != 0) {
                              dist[i][j] = graph[i][j]; // Use graph weight
                        } else {
                              dist[i][j] = INF; // No edge
                        }
                  }
            }

            // Floyd-Warshall algorithm
            for (int k = 0; k < vertices; k++) {
                  for (int i = 0; i < vertices; i++) {
                        for (int j = 0; j < vertices; j++) {
                              if (dist[i][k] != INF && dist[k][j] != INF) {
                                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                              }
                        }
                  }
            }

            // Print the result
            printSolution(dist);
      }

      public static void printSolution(int[][] dist) {
            int vertices = dist.length;
            System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
            for (int i = 0; i < vertices; i++) {
                  for (int j = 0; j < vertices; j++) {
                        if (dist[i][j] == INF) {
                              System.out.print("INF ");
                        } else {
                              System.out.print(dist[i][j] + " ");
                        }
                  }
                  System.out.println();
            }
      }

      public static void main(String[] args) {
            // Example graph represented as an adjacency matrix
            int[][] graph = {
                    {0, 3, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 7, 0, 2},
                    {0, 0, 0, 0, 2, 0},
                    {0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0}
            };

            floydWarshall(graph);
      }
}

