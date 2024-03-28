package Trees;

import java.util.ArrayList;
import java.util.List;

public class Binary_tree_traversal {

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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorder_traversal(root, list);
            return list;
        }

        public void inorder_traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder_traversal(root.left, list);
            list.add(root.val);
            inorder_traversal(root.right, list);
        }

        public void preorder_traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            preorder_traversal(root.left, list);
            preorder_traversal(root.right, list);
        }

        public void postorder_traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postorder_traversal(root.left, list);
            postorder_traversal(root.right, list);
            list.add(root.val);
        }

    }
}
