package Graphs.Algorithms;

import java.util.ArrayList;

public class Graph {
      public static class Edge{
            int src ;
            int dest ;
            int cost ;
            Edge(int src, int dest , int cost){
                  this.src = src;
                  this.dest = dest;
                  this.cost = cost;
            }
      }

       ArrayList<ArrayList<Edge>> adj;
       int size;
      Graph(int nodes){
            this.size = nodes;
            adj = new ArrayList<> ();
            for(int i = 0; i < size; i++){
                  adj.add(new ArrayList<> ());
            }
      }

      public void add_directed_edge(int src, int dest , int cost){
            Edge edge = new Edge (src, dest, cost);
            adj.get(src).add(edge);
      }
      public void add_undirected_edge(int src, int dest, int cost){
            add_directed_edge (src, dest, cost);
            add_directed_edge (dest, src, cost);
      }
      public void display_graph(){
            int nodes = size;
            for(int i = 0; i < nodes; i++){
                  System.out.print("source "+i + " -> ");
                  for(Edge edge : adj.get(i)){
                        System.out.print( "["+edge.src +"-"+ edge.dest +"-@-"+ edge.cost +"] ,");
                  }
                  System.out.println();
            }
            System.out.println ();
      }
}
