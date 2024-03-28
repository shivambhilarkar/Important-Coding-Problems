package Graphs.Algorithms;


import java.util.PriorityQueue;
import java.util.Scanner;

//Dijkstra Algorithm
//shortest Path from source vertex to each other vertex
public class Dijkstra_Algorithm {
      public static class Pair implements Comparable<Pair>{
            int node;
            int weight;
            String psf;
            Pair(int node, int weight, String psf){
                  this.node = node;
                  this.weight = weight;
                  this.psf = psf;
            }

            public int compareTo(Pair o){
                  return this.weight - o.weight;
            }
      }

      public static void print_shortest_path_from_source(Graph graph, int src){
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            int size = graph.size;
            boolean[] visited = new boolean[size];
            queue.add(new Pair(src, 0 , src+""));

            while(queue.isEmpty() == false){
                  Pair removed = queue.remove();

                  if(visited[removed.node] == true){
                        continue;
                  }
                  visited[removed.node] = true;
                  System.out.println(removed.node + "via ->" +removed.psf +"-@-"+removed.weight);
                  for(Graph.Edge edge : graph.adj.get(removed.node)){
                        if(visited[edge.dest] == false){
                              queue.add(new Pair (edge.dest, removed.weight+edge.cost , removed.psf + edge.dest));
                        }
                  }
            }
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            Graph graph = new Graph (6);
            graph.add_undirected_edge(0,1, 10);
            graph.add_undirected_edge(0,3, 10);
            graph.add_undirected_edge(1,2, 10);
            graph.add_undirected_edge(2,3, 10);
            graph.add_undirected_edge(3,4, 10);
            graph.add_undirected_edge(4,5, 10);
            graph.add_undirected_edge(3,5, 10);

            graph.display_graph();

            print_shortest_path_from_source(graph , 0);

      }
}
