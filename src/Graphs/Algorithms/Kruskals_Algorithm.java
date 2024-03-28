package Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

//kruskal's Algorithm for minimum spanning tree...
public class Kruskals_Algorithm {
      public static void kruskal_algorithm(Graph graph){
            ArrayList<Graph.Edge> list = get_edges(graph);

            int size = graph.size;
            Disjoint_set ds = new Disjoint_set(size);

            int costmst = 0;
            ArrayList<Graph.Edge> mst = new ArrayList<>();
            for(Graph.Edge edge : list){
                  if(ds.find(edge.src) != ds.find(edge.dest)){
                        costmst += edge.cost;
                        mst.add(edge);
                        ds.union(edge.src , edge.dest);
                  }
            }
            System.out.println(costmst);
            System.out.print("EDGES : ");
            for(Graph.Edge edge: mst){
                  System.out.print( "["+edge.src +"->"+edge.dest+"-@-"+edge.cost+"] , ");
            }
      }

      public static ArrayList<Graph.Edge> get_edges(Graph graph){
            ArrayList<Graph.Edge> list = new ArrayList<>();
            int size = graph.size;
            for(int i = 0; i < size; i++){
                  for(Graph.Edge edge : graph.adj.get(i)){
                        list.add(edge);
                  }
            }
            return list;
      }

      public static void main(String[] args){
            Scanner scan = new Scanner(System.in);

            Graph graph = new Graph (6);
            graph.add_undirected_edge(0,1, 10);
            graph.add_undirected_edge(0,3, 10);
            graph.add_undirected_edge(1,2, 10);
            graph.add_undirected_edge(2,3, 10);
            graph.add_undirected_edge(3,4, 10);
            graph.add_undirected_edge(4,5, 10);
            graph.add_undirected_edge(3,5, 10);

            graph.display_graph();

            kruskal_algorithm (graph);
      }
}
