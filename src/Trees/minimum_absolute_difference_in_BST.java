package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minimum_absolute_difference_in_BST {
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
        public int getMinimumDifference(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            get_nodes(root, list);
            if (list.size() < 2) {
                return 0;
            } else {
                //make get_nodes as inorder_traversal ; don't need to sort list
                Collections.sort(list);
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < list.size() - 1; i++) {
                    int diff = Math.abs(list.get(i) - list.get(i + 1));
                    min = Math.min(diff, min);
                }
                return min;
            }

        }

        public void get_nodes(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            get_nodes(root.left, list);
            get_nodes(root.right, list);
        }
    }

}
