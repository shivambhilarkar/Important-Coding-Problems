package Graphs.PracticeQuestions;

public class Q10_redundant_connection {
      class Solution {
            //disjoint set union data structure
            class DSU {
                  int[] parents;
                  int nodes;

                  DSU(int nodes) {
                        this.nodes = nodes;
                        this.parents = new int[nodes];
                        for (int i = 0; i < nodes; i++) {
                              parents[i] = i;
                        }
                  }

                  public int findParent(int node) {
                        if (parents[node] == node) {
                              return node;
                        }
                        return findParent(parents[node]);
                  }

                  public void simpleUnion(int node1, int node2) {
                        parents[node2] = node1;
                  }
            }

            public int[] findRedundantConnection(int[][] edges) {
                  int nodes = edges.length + 1;
                  DSU dsu = new DSU(nodes);

                  for (int[] edge : edges) {
                        int parent1 = dsu.findParent(edge[0]);
                        int parent2 = dsu.findParent(edge[1]);
                        //both belongs to different group
                        if (parent1 != parent2) {
                              dsu.simpleUnion(parent1, parent2);
                        } else {
                              //already belongs to same group
                              //dont need to add current edge
                              //so it is redundant edge/connection
                              return new int[]{edge[0], edge[1]};
                        }
                  }
                  return new int[]{0};
            }
      }

      public static void main(String[] args) {

      }
}
