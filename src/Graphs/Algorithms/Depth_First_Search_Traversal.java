package Graphs.Algorithms;

import java.util.Scanner;

//Depth first search to find out if path is exist between source & destination....
public class Depth_First_Search_Traversal {

      public static boolean DFS(Graph graph, int source , int dest){
            int count = graph.size;
            boolean[] visited = new boolean[count];
            depth_first_recursion(graph, source, visited);
            return visited[dest];
      }
      public static  void depth_first_recursion(Graph graph, int source, boolean[] visited){

            visited[source] = true;
            for(Graph.Edge edge : graph.adj.get(source)){
                  if(visited[edge.dest] == false){
                        depth_first_recursion (graph, edge.dest, visited);
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
            System.out.println(DFS (graph, 0 , 4) );


      }
}
