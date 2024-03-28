package DS_Implementations.Graph;

import java.util.ArrayList;
import java.util.Scanner;

class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Graph {


    ArrayList<ArrayList<Edge>> adj;
    int size;

    Graph(int nodes) {
        this.size = nodes;
        adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void add_directed_edge(int src, int dest) {
        Edge edge = new Edge(src, dest);
        adj.get(src).add(edge);
    }

    public void add_undirected_edge(int src, int dest) {
        add_directed_edge(src, dest);
        add_directed_edge(dest, src);
    }

    public void display_graph() {
        int nodes = size;
        for (int i = 0; i < nodes; i++) {
            System.out.print("src : " + i + " : -> ");
            for (Edge edge : adj.get(i)) {
                System.out.print(edge.dest + " , ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


//for unweighted Graph
public class Graph_Representation_Adj_list {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Graph graph = new Graph(6);

        graph.add_undirected_edge(0, 3);
        graph.add_undirected_edge(0, 1);
        graph.add_undirected_edge(1, 2);
        graph.add_undirected_edge(2, 3);
        graph.add_undirected_edge(3, 4);
        graph.add_undirected_edge(4, 5);
        graph.add_undirected_edge(3, 5);

        graph.display_graph();


    }

}
