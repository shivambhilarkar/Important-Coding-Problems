package Trees;

import java.util.ArrayList;
import java.util.List;

public class leaf_similar_binary_trees_boolean {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            ArrayList<Integer> root1_leafs = new ArrayList<>();
            ArrayList<Integer> root2_leafs = new ArrayList<>();
            get_leafs(root1, root1_leafs);
            get_leafs(root2, root2_leafs);
            if (root1_leafs.size() != root2_leafs.size()) {
                return false;
            }
            for (int i = 0; i < root1_leafs.size(); i++) {
                if (root1_leafs.get(i) != root2_leafs.get(i)) {
                    return false;
                }
            }
            return true;
        }

        public void get_leafs(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }
            get_leafs(root.left, list);
            get_leafs(root.right, list);
        }
    }
}
