package Trees;

public class tilt_of_Binary_tree {
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
        int sum = 0;

        public int findTilt(TreeNode root) {
            tilt_of_binaryTree(root);
            return sum;
        }

        public int tilt_of_binaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int right_tree = tilt_of_binaryTree(root.right);
            int left_tree = tilt_of_binaryTree(root.left);

            sum += Math.abs(right_tree - left_tree);
            return right_tree + left_tree + root.val;
        }
    }

}
