package Graphs.PracticeQuestions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/description/
 */
public class Q5_course_schedule_I {
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

                  public void addDirectedEdge(int src, int dest) {
                        this.adj.get(src).add(dest);
                  }
            }

            public boolean canFinish(int numCourses, int[][] prerequisites) {
                  if (numCourses == 0) return true;
                  //graph construction
                  Graph graph = new Graph(numCourses);
                  for (int[] edge : prerequisites) {
                        graph.addDirectedEdge(edge[0], edge[1]);
                  }
                  //count indegrees of each node
                  int[] inDegrees = new int[numCourses];
                  for (int i = 0; i < numCourses; i++) {
                        for (int nbr : graph.adj.get(i)) {
                              inDegrees[nbr] += 1;
                        }
                  }

                  Queue<Integer> queue = new ArrayDeque<>();
                  //add nodes which has zero indegrees
                  for (int i = 0; i < numCourses; i++) {
                        if (inDegrees[i] == 0) {
                              queue.add(i);
                        }
                  }
                  //store topological ordering in array.
                  int[] toposort = new int[numCourses];
                  int index = toposort.length-1;
                  int count = 0;
                  //simple bfs
                  while (queue.isEmpty() == false) {
                        int node = queue.poll();
                        // store nodes as topological ordering
                        toposort[index--] = node;
                        // count how many nodes has been visited
                        count += 1;
                        for (int nbr : graph.adj.get(node)) {
                              inDegrees[nbr] -= 1;
                              if (inDegrees[nbr] == 0) {
                                    queue.add(nbr);
                              }
                        }
                  }
                  return count == numCourses;
            }
      }

      public static void main(String[] args) {

      }
}
