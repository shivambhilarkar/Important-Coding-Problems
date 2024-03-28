package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class average_of_levels_in_binary_tree {
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> avg_list = new ArrayList<>();
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (queue.isEmpty() == false) {
                int size = queue.size();
                double sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode removed = queue.remove();
                    sum += removed.val;
                    if (removed.left != null) {
                        queue.add(removed.left);
                    }
                    if (removed.right != null) {
                        queue.add(removed.right);
                    }
                }
                avg_list.add(sum / size);
            }
            return avg_list;

        }
    }

}
