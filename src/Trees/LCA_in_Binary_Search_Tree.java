package Trees;

public class LCA_in_Binary_Search_Tree {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int min = Math.min(p.val, q.val);
            int max = Math.max(p.val, q.val);

            while (root != null) {
                if (root.val < min) {
                    root = root.right;
                } else if (root.val > max) {
                    root = root.left;
                } else {
                    return root;
                }
            }
            return null;

        }
    }

}
