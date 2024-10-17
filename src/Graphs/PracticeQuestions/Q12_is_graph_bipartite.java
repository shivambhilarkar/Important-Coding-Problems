package Graphs.PracticeQuestions;

/** Graph Coloring Concept
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class Q12_is_graph_bipartite {
      class Solution {
            public boolean isBipartite(int[][] graph) {
                  if (graph.length == 0) return true;

                  int nodes = graph.length;
                  int[] colors = new int[nodes];
                  for (int i = 0; i < nodes; i++) {
                        if (colors[i] == 0 && isValid(i, 1, colors, graph) == false) {
                              return false;
                        }
                  }
                  return true;
            }

            //graph coloring method,inversing color for adjacent nodes;
            private boolean isValid(int src, int color, int[] colors, int[][] graph) {
                  if (colors[src] != 0) {
                        return colors[src] == color;
                  }
                  colors[src] = color;
                  for (int nbr : graph[src]) {
                        if (isValid(nbr, -color, colors, graph) == false) {
                              return false;
                        }
                  }
                  return true;
            }
      }

      public static void main(String[] args) {

      }
}
