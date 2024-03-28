package Trees;

public class sum_of_root_to_leaf_imp {
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
        public int sumRootToLeaf(TreeNode root) {
            int sum = 0;
            preorder_traversal(root, sum);
            return total_sum;
        }

        int total_sum = 0;

        public void preorder_traversal(TreeNode root, int sum) {
            if (root != null) {
                sum = (sum << 1) | root.val;

                if (root.left == null && root.right == null) {
                    total_sum += sum;
                }
                preorder_traversal(root.left, sum);
                preorder_traversal(root.right, sum);
            }
        }
    }

}
