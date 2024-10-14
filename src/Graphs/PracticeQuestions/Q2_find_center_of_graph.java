package Graphs.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/find-center-of-star-graph/description/
 */
public class Q2_find_center_of_graph {


      class Solution {
            class Graph {
                  List<List<Integer>> adj;
                  int nodes;

                  Graph(int nodes) {
                        this.nodes = nodes;
                        this.adj = new ArrayList<>();
                        for (int i = 0; i <= nodes; i++) {
                              this.adj.add(new ArrayList<>());
                        }
                  }

                  public void addUndirectedEdge(int src, int dest) {
                        this.adj.get(src).add(dest);
                        this.adj.get(dest).add(src);
                  }

                  public int getCenter() {
                        for (int i = 1; i <= nodes; i++) {
                              int edges = this.adj.get(i).size();
                              if (edges == nodes - 1) {
                                    return i;
                              }
                        }
                        return -1;
                  }
            }

            public int findCenter(int[][] edges) {
                  int nodes = edges.length;
                  Graph graph = new Graph(nodes + 1);
                  for (int[] edge : edges) {
                        graph.addUndirectedEdge(edge[0], edge[1]);
                  }
                  int centerNode = graph.getCenter();
                  return centerNode;
            }
      }

      public static void main(String[] args) {

      }
}
