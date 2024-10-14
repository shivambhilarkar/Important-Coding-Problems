package Graphs.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/find-the-town-judge/description/
 */
public class Q3_find_the_town_judge {
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

                  public void addDirectedEdge(int src, int dest) {
                        // this.adj.get(src).add(dest);
                        this.adj.get(dest).add(src); //convert to incoming edge
                  }

                  public int findJudge() {
                        boolean[] visited = new boolean[nodes + 1];
                        for (int i = 1; i <= nodes; i++) {
                              List<Integer> nbrs = adj.get(i);
                              for (int nbr : nbrs) {
                                    visited[nbr] = true;
                              }
                        }
                        for (int i = 1; i <= nodes; i++) {
                              //judge trust nobody
                              if (visited[i] == false) {
                                    //everybody knows judge
                                    if (adj.get(i).size() == nodes - 1) {
                                          return i;
                                    }
                              }
                        }
                        return -1;
                  }
            }


            public int findJudge(int n, int[][] trust) {
                  Graph graph = new Graph(n);
                  for (int[] edge : trust) {
                        graph.addDirectedEdge(edge[0], edge[1]);
                  }
                  return graph.findJudge();
            }
      }

      public static void main(String[] args) {

      }
}
