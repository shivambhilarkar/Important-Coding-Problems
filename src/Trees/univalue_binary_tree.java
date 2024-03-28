package Trees;

import java.util.ArrayDeque;

public class univalue_binary_tree {
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
        public boolean isUnivalTree(TreeNode root) {
            if (root == null)
                return true;

            int value = root.val;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (queue.isEmpty() == false) {
                TreeNode removed = queue.remove();
                if (removed.val != value) {
                    return false;
                }
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            return true;
        }
    }

}
