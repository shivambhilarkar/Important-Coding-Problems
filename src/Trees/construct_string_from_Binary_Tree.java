package Trees;

public class construct_string_from_Binary_Tree {
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
        String path = "";

        public String tree2str(TreeNode root) {
            preorder_traversal(root);
            return path;
        }

        public void preorder_traversal(TreeNode root) {
            if (root == null) {
                return;
            }
            path += root.val + "";
            if (root.left == null && root.right == null) {
                return;
            }
            if (root.left == null) {
                path += "()";
            }
            path += "(";
            preorder_traversal(root.left);

            if (root.left != null && root.right != null) {
                path += ")(";
            }
            preorder_traversal(root.right);
            path += ")";
        }
    }

}
