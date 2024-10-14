package Graphs.PracticeQuestions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Easy
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 */

public class Q1_find_path_exist_between_source_and_destination {

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

                  public boolean check_path_exist(int source, int dest) {
                        if (source == dest) return true;
                        Queue<Integer> queue = new ArrayDeque<>();
                        queue.add(source);

                        boolean[] visited = new boolean[nodes];
                        while (queue.isEmpty() == false) {
                              int size = queue.size();
                              for (int i = 0; i < size; i++) {
                                    int top = queue.poll();
                                    for (int nbr : adj.get(top)) {
                                          // no need to search further
                                          if (nbr == dest) {
                                                return true;
                                          }

                                          if (visited[nbr] == false) {
                                                queue.add(nbr);
                                                visited[nbr] = true;
                                          }
                                    }
                              }
                        }
                        return visited[dest];
                  }

            }


            public boolean validPath(int n, int[][] edges, int source, int destination) {

                  Graph graph = new Graph(n);
                  for (int[] edge : edges) {
                        graph.addUnDirectedEdge(edge[0], edge[1]);
                  }

                  boolean result = graph.check_path_exist(source, destination);
                  return result;
            }
      }

      public static void main(String[] args) {

      }
}
