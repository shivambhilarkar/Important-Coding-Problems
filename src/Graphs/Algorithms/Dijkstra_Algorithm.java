package Graphs.Algorithms;


import java.util.Arrays;
import java.util.List;
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

            while(!queue.isEmpty()){
                  Pair removed = queue.remove();

                  if(visited[removed.node]){
                        continue;
                  }
                  visited[removed.node] = true;
                  System.out.println(removed.node + "via ->" +removed.psf +"-@-"+removed.weight);
                  for(Graph.Edge edge : graph.adj.get(removed.node)){
                        if(!visited[edge.dest]){
                              queue.add(new Pair (edge.dest, removed.weight+edge.cost , removed.psf + edge.dest));
                        }
                  }
            }
      }


      // naive approach - relaxation based.
      public void naiveSolution(int source, List<List<Graph.Edge>> adj){
            int total_nodes = adj.size();
            int[] distance = new int[total_nodes];
            Arrays.fill(distance, Integer.MAX_VALUE);
            boolean[] visited = new boolean[total_nodes];
            distance[source] = 0;

            for(int i = 0; i < total_nodes-1; i++){
                  int minIndex = -1;
                  int minDistance = Integer.MAX_VALUE;
                  for(int j = 0; j < total_nodes; j++){
                        if(visited[j] == false &&
                              distance[j] < minDistance){
                              minDistance = distance[j];
                              minIndex = j;
                        }
                  }
                  //if no vertex is found then break;
                  if(minIndex == -1) break;

                  //mark the chosen vertex as visited
                  visited[minIndex] = true;
                  //relaxation process
                  for(Graph.Edge edge: adj.get(minIndex)){
                        if(visited[edge.dest] == false){
                              int newDistance = distance[minIndex] + edge.cost;
                              if(newDistance < distance[edge.dest]){
                                    distance[edge.dest] = newDistance;
                              }
                        }
                  }
            }

            // distance
            for(int i = 0; i < total_nodes; i++){
                  System.out.println("Source: "+ source +" -> "+ i + " weight: "+ distance[i]);
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
