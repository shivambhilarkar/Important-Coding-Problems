package Trees;

// Definition for a binary tree node.
public class sum_of_left_leaves_of_Binary_tree {

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
        public int sumOfLeftLeaves(TreeNode root) {
            get_leftLeavs(root);
            return sum;
        }

        int sum = 0;

        public void get_leftLeavs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null && (root.left.left == null && root.left.right == null)) {
                sum += root.left.val;
            }
            get_leftLeavs(root.left);
            get_leftLeavs(root.right);
        }
    }
}