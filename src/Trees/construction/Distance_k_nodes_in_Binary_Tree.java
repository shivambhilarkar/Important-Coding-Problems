package Trees.construction;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class Distance_k_nodes_in_Binary_Tree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();

        Map<TreeNode, TreeNode> map = new HashMap<>();
        getParents(root, null, map);

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;
        while (queue.isEmpty() == false) {
            int size = queue.size();

            //if distance is achieved return nodes at distance
            if (distance == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                //check for left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                }
                //check for right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                }
                //check for parent side / up side
                TreeNode parentNode = map.get(current);
                if (parentNode != null && !visited.contains(parentNode)) {
                    queue.add(parentNode);
                    visited.add(parentNode);
                }
            }
            distance += 1;
        }
        return result;
    }

    //find out parents for each node and store in map.
    private void getParents(TreeNode child, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (child == null) return;

        map.put(child, parent);
        getParents(child.left, child, map);
        getParents(child.right, child, map);
    }


}
