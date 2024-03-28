package Trees;

// *Definition for a binary tree node.*
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // preorder_traversal(root, low, high);
        // return sum;
        return range_bst(root, low, high);
    }

    int sum = 0;

    public void preorder_traversal(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        preorder_traversal(root.left, low, high);
        preorder_traversal(root.right, low, high);

    }

    public int range_bst(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return range_bst(root.left, low, high);
        }
        if (root.val < low) {
            return range_bst(root.right, low, high);
        }

        int sum = root.val + range_bst(root.left, low, high) + range_bst(root.right, low, high);
        return sum;
    }
}
