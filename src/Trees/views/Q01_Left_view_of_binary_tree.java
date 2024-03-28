package Trees.views;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Q01_Left_view_of_binary_tree {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class Tree {
        // Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> leftView(Node root) {
            ArrayList<Integer> nodes = new ArrayList<>();
            if (root == null)
                return nodes;
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(root);
            while (queue.isEmpty() == false) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node top = queue.remove();
                    if (i == 0) {
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