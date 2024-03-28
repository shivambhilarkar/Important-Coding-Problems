package Graphs.Algorithms;

import java.util.Scanner;
import java.util.Stack;

//Topological sort is only work on Directed Acyclic Graph.(DAG).
public class Topological_Sorting_ {
      public static void Toposort(Graph graph){
            int size = graph.size;
            boolean[] visited = new boolean[size];
            Stack<Integer> stack = new Stack<> ();

            for(int node = 0; node< size; node++){
                  if(visited[node] == false){
                        dfs_with_stack(graph, node, visited, stack);
                  }
            }
            System.out.print("Toposort : ");
            while(stack.isEmpty () == false){
                  System.out.print(stack.pop() + " , ");
            }
      }

      public static void dfs_with_stack(Graph graph, int source, boolean[] visited, Stack<Integer> stk){
            visited[source] = true;
            for(Graph.Edge edge : graph.adj.get(source)){
                  if(visited[edge.dest] == false){
                        dfs_with_stack(graph, edge.dest, visited, stk);
                  }
            }
            stk.add(source);
      }

      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            Graph graph = new Graph (9);

            graph.add_directed_edge(0,2,10);
            graph.add_directed_edge(1,2,10);
            graph.add_directed_edge(1,3,10);
            graph.add_directed_edge(1,4,10);
            graph.add_directed_edge(3,2,10);
            graph.add_directed_edge(3,5,10);
            graph.add_directed_edge(4,5,10);
            graph.add_directed_edge(4,6,10);
            graph.add_directed_edge(5,7,10);
            graph.add_directed_edge(6,7,10);
            graph.add_directed_edge(7,8,10);

            graph.display_graph();
            Toposort(graph);
      }

}
