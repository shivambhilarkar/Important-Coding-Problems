package DS_Implementations.Graph;

import java.util.Scanner;

class Graph_ {
    static int[][] matrix;
    static int size;

    Graph_(int nodes) {
        matrix = new int[nodes][nodes];
        size = nodes;
    }

    public void add_directed_edge(int src, int dest) {
        matrix[src][dest] = 1;
    }

    public void add_undirected_edge(int src, int dest) {
        add_directed_edge(src, dest);
        add_directed_edge(dest, src);
    }

    public void display_graph() {
        int nodes = size;
        for (int i = 0; i < nodes; i++) {
            System.out.print("src : " + i + " -> ");
            for (int j = 0; j < nodes; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(j + " , ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}


//for unweighted Graph
public class Graph_Representation_adj_matrix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Graph_ graph = new Graph_(6);
        graph.add_undirected_edge(0, 1);
        graph.add_undirected_edge(0, 3);
        graph.add_undirected_edge(1, 2);
        graph.add_undirected_edge(2, 3);
        graph.add_undirected_edge(3, 4);
        graph.add_undirected_edge(4, 5);
        graph.add_undirected_edge(3, 5);

        graph.display_graph();

    }

}
