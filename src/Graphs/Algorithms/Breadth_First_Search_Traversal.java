package Graphs.Algorithms;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Breadth_First_Search_Traversal {
      public static class Path{
            int last;
            String psf;
            Path(int last, String psf){
                  this.last = last;
                  this.psf = psf;
            }
      }
      public static void BFS(Graph graph, int src, int dest){
            int size = graph.size;
            boolean[] visited = new boolean[size];

            ArrayDeque<Path> queue = new ArrayDeque<> ();
            queue.add(new Path(src, src+""));
            visited[src] = true;

            while(queue.isEmpty () == false){
                  Path removed = queue.remove();
                  for(Graph.Edge edge : graph.adj.get(removed.last)){
                        if(visited[edge.dest] == false) {
                              visited[edge.dest] = true;
                              queue.add (new Path (edge.dest, removed.psf +"-"+ edge.dest));

                              if(edge.dest == dest){
                                    System.out.println(removed.psf +"-"+ dest);
                              }
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

            BFS(graph, 1 , 5);

      }
}
