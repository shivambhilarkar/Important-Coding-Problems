package Graphs.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/** Dijkstra Algorithm Question
 * https://leetcode.com/problems/network-delay-time/
 */
public class Q11_network_delay_time {
      class Solution {
            class Edge {
                  int src;
                  int dest;
                  int weight;

                  Edge(int src, int dest, int weight) {
                        this.src = src;
                        this.dest = dest;
                        this.weight = weight;
                  }
            }

            class Graph {
                  List<List<Edge>> adj;
                  int nodes;

                  Graph(int nodes) {
                        this.nodes = nodes;
                        this.adj = new ArrayList<>();
                        for (int i = 0; i < nodes; i++) {
                              this.adj.add(new ArrayList<>());
                        }
                  }

                  public void addDirectedEdge(int src, int dest, int weight) {
                        Edge edge = new Edge(src, dest, weight);
                        this.adj.get(src).add(edge);
                  }
            }

            class Pair implements Comparable<Pair> {
                  int node;
                  int weight;

                  Pair(int node, int weight) {
                        this.node = node;
                        this.weight = weight;
                  }

                  @Override
                  public int compareTo(Pair other) {
                        return this.weight - other.weight;
                  }
            }


            public int networkDelayTime(int[][] times, int n, int k) {
                  Graph graph = new Graph(n + 1);
                  for (int[] edge : times) {
                        graph.addDirectedEdge(edge[0], edge[1], edge[2]);
                  }

                  PriorityQueue<Pair> queue = new PriorityQueue<>();
                  queue.add(new Pair(k, 0));
                  boolean[] visited = new boolean[n + 1];

                  int result = 0;
                  int visitedNodesCount = n;
                  while (queue.isEmpty() == false) {
                        Pair current = queue.poll();
                        if (visited[current.node]) {
                              continue;
                        }
                        visited[current.node] = true;
                        visitedNodesCount -= 1;

                        result = Math.max(current.weight, result);
                        for (Edge edge : graph.adj.get(current.node)) {
                              if (visited[edge.dest] == false) {
                                    queue.add(new Pair(edge.dest, current.weight + edge.weight));
                              }
                        }
                  }
                  return visitedNodesCount == 0 ? result : -1;
            }
      }

      public static void main(String[] args) {

      }
}
