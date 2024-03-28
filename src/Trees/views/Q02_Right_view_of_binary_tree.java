package Trees.views;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Q02_Right_view_of_binary_tree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class Solution {
        // Function to return list containing elements of right view of binary tree.
        public ArrayList<Integer> rightView(Node node) {
            ArrayList<Integer> nodes = new ArrayList<>();
            if (node == null)
                return nodes;
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);
            while (queue.isEmpty() == false) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node top = queue.remove();
                    if (i == size - 1) {
                        nodes.add(top.data);
                    }
                    if (top.left != null) {
                        queue.add(top.left);
                    }
                    if (top.right != null) {
                        queue.add(top.right);
                    }
                }
            }
            return nodes;
        }
    }

}
