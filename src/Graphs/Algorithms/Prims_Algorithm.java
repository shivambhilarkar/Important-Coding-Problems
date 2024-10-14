package Graphs.Algorithms;

import java.util.PriorityQueue;
import java.util.Scanner;

//Prim's Algorithm for Minimum Spanning Tree
public class Prims_Algorithm {
      public static class Pair implements Comparable<Pair>{
            int child;
            int parent;
            int weight;
            Pair(int child, int parent, int weight){
                  this.child = child;
                  this.parent = parent;
                  this.weight = weight;
            }
            public int compareTo(Pair o){
                  return this.weight - o.weight;
            }
      }

      public static void mst_prims_algorithm(Graph graph, int src){
            int size = graph.size;
            boolean[] visited = new boolean[size];
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            queue.add(new Pair(src, -1, 0)); //current node

            while(!queue.isEmpty()){
                  Pair removed = queue.remove();

                  if(visited[removed.child]){
                        continue;
                  }
                  visited[removed.child] = true;

                  if(removed.parent != -1){ //to exclude start node
                        System.out.println(removed.child +" -> "+ removed.parent + " -@- "+removed.weight);
                  }
                  for(Graph.Edge edge : graph.adj.get(removed.child)){
                        if(!visited[edge.dest]){
                              queue.add(new Pair(edge.dest , removed.child, edge.cost));
                        }
                  }
            }
      }


      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);

            Graph graph = new Graph (6);
            graph.add_undirected_edge(0,1, 40);
            graph.add_undirected_edge(0,3, 20);
            graph.add_undirected_edge(1,2, 10);
            graph.add_undirected_edge(2,3, 10);
            graph.add_undirected_edge(3,4, 10);
            graph.add_undirected_edge(4,5, 10);
            graph.add_undirected_edge(3,5, 30);

            graph.display_graph();

            mst_prims_algorithm (graph, 0);
      }
}
