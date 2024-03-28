package Trees;

import java.util.HashSet;

// Given the root of a Binary Search Tree and a target number k, 
// return true if there exist two elements in the BST such that their sum is equal to the given target
public class two_sum_find_pair_with_given_value_in_bst {
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
        public boolean findTarget(TreeNode root, int k) {
            HashSet<Integer> set = new HashSet<>();
            return find_pair(root, k, set);
        }

        public boolean find_pair(TreeNode root, int k, HashSet<Integer> set) {
            if (root == null) {
                return false;
            }

            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);

            return find_pair(root.left, k, set) || find_pair(root.right, k, set);
        }
    }

}
