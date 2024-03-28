package Trees.views;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

public class Q04_Bottom_view_of_binary_tree {
    class Solution {
        class Node {
            int data;
            Node left, right;

            Node(int item) {
                data = item;
                left = right = null;
            }
        }

        class Pair {
            Node node;
            int level;

            Pair(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        // Function to return a list containing the bottom view of the given tree.
        public ArrayList<Integer> bottomView(Node root) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(root, 0));
            while (queue.isEmpty() == false) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Pair top = queue.remove();
                    map.put(top.level, top.node.data);// adding to map
                    if (top.node.left != null) {
                        queue.add(new Pair(top.node.left, top.level - 1));
                    }
                    if (top.node.right != null) {
                        queue.add(new Pair(top.node.right, top.level + 1));
                    }
                }
            }
            ArrayList<Integer> lst = new ArrayList<>();
            for (int node : map.values()) {
                lst.add(node);
            }
            return lst;
        }
    }
}
