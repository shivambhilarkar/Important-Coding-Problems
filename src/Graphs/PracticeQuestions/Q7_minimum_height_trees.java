package Graphs.PracticeQuestions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q7_minimum_height_trees {
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

            public void addUndirectedEdge(int src, int dest) {
                this.adj.get(src).add(dest);
                this.adj.get(dest).add(src);
            }
        }

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 0) return new ArrayList<>();
            if (n == 1) {
                List<Integer> result = new ArrayList<>();
                result.add(0);
                return result;
            }

            Graph graph = new Graph(n);
            for (int[] edge : edges) {
                graph.addUndirectedEdge(edge[0], edge[1]);
            }
            //calculate in degrees
            int[] inDegrees = new int[n];
            for (int i = 0; i < n; i++) {
                for (int nbr : graph.adj.get(i)) {
                    inDegrees[nbr] += 1;
                }
            }
            Queue<Integer> queue = new ArrayDeque<>();
            //nodes which has one indegree can be assumed as leaf nodes
            //add nodes in queue which are leaf nodes
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 1) {
                    queue.add(i);
                }
            }
            //maximum Miminum height trees root can be two
            //exp : 1 <-> 2 ; here 1 & 2 boths are candidate for root, with height 1
            //simple bfs -> only removing leaf nodes
            List<Integer> result = new ArrayList<>();
            while (queue.isEmpty() == false) {
                int size = queue.size();
                result.clear();
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();
                    result.add(node);
                    for (int nbr : graph.adj.get(node)) {
                        inDegrees[nbr] -= 1;
                        //if it becomes next leaf node
                        if (inDegrees[nbr] == 1) {
                            queue.add(nbr);
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
