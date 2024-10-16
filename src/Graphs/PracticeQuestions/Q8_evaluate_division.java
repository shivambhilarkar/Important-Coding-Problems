package Graphs.PracticeQuestions;

import java.util.*;

public class Q8_evaluate_division {

    class Solution {
        class Graph {
            Map<String, Map<String, Double>> adj;

            Graph() {
                this.adj = new HashMap<>();
            }

            public void addUnDirectedEdge(String src, String dest, Double weight) {
                this.adj.putIfAbsent(src, new HashMap<>());
                this.adj.get(src).put(dest, weight);

                this.adj.putIfAbsent(dest, new HashMap<>());
                this.adj.get(dest).put(src, 1 / weight);
            }
        }


        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            //create graph
            Graph graph = new Graph();
            //add edge with weight values
            for (int i = 0; i < equations.size(); i++) {
                String src = equations.get(i).get(0);
                String dest = equations.get(i).get(1);
                double weight = values[i];
                graph.addUnDirectedEdge(src, dest, weight);
            }
            //get result for each queires src-> dest
            double[] result = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String src = queries.get(i).get(0);
                String dest = queries.get(i).get(1);
                result[i] = dfs(src, dest, new HashSet<>(), graph);
            }
            return result;
        }

        public double dfs(String src, String dest, Set<String> visited, Graph graph) {
            if (graph.adj.containsKey(src) == false) {
                return -1.0;
            }
            if (graph.adj.get(src).containsKey(dest)) {
                return graph.adj.get(src).get(dest);
            }
            visited.add(src);
            for (Map.Entry<String, Double> nbr : graph.adj.get(src).entrySet()) {
                if (visited.contains(nbr.getKey()) == false) {
                    double weight = dfs(nbr.getKey(), dest, visited, graph);

                    if (weight != -1.0) {
                        return nbr.getValue() * weight;
                    }
                }
            }
            return -1.0;
        }
    }

    public static void main(String[] args) {

    }
}
