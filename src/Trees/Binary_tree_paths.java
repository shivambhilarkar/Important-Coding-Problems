package Trees;

import java.util.ArrayList;
import java.util.List;

public class Binary_tree_paths {
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
        public List<String> binaryTreePaths(TreeNode root) {
            String psf = "";
            List<String> paths = new ArrayList<>();
            preorder_traversal(root, psf, paths);
            return paths;
        }

        public void preorder_traversal(TreeNode root, String psf, List<String> list) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                psf += root.val;
                list.add(psf);
                return;
            }
            preorder_traversal(root.left, psf + root.val + "->", list);
            preorder_traversal(root.right, psf + root.val + "->", list);
        }
    }

}
