package Trees;

import java.util.ArrayDeque;

public class maximum_depth_of_binary_tree {
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
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int level_counter = 0;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (queue.isEmpty() == false) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode removed = queue.remove();
                    if (removed.left != null) {
                        queue.add(removed.left);
                    }
                    if (removed.right != null) {
                        queue.add(removed.right);
                    }
                }
                level_counter += 1;
            }
            return level_counter;
        }
    }

}
