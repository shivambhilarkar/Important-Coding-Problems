package Graphs.PracticeQuestions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4_clone_graph {

      //node representation
      class Node {
            public int val;
            public List<Node> neighbors;

            public Node() {
                  val = 0;
                  neighbors = new ArrayList<Node>();
            }

            public Node(int _val) {
                  val = _val;
                  neighbors = new ArrayList<Node>();
            }

            public Node(int _val, ArrayList<Node> _neighbors) {
                  val = _val;
                  neighbors = _neighbors;
            }
      }

      class Solution {
            public Node cloneGraph(Node node) {
                  if (node == null) return null;
                  return getClonedGraph(node, new HashMap<>());
            }

            public Node getClonedGraph(Node node, Map<Node, Node> map) {
                  //if already visited then return node.
                  if (map.containsKey(node)) {
                        return map.get(node);
                  }
                  //store in map for visited
                  Node currentNode = new Node(node.val);
                  map.put(node, currentNode);

                  //adding neighbors to current node.
                  List<Node> neighbors = new ArrayList<>();
                  for (Node nbr : node.neighbors) {
                        Node temp = getClonedGraph(nbr, map);
                        neighbors.add(temp);
                  }
                  currentNode.neighbors = neighbors;
                  return currentNode;
            }


      }

      public static void main(String[] args) {

      }
}
