package DynamicProgramming.DP_on_trees;


import java.util.ArrayList;
import java.util.List;


/**
 * this question not present on leetcode,may be it is in premium section
 * TODO : Amazon OA
 */

class TreeNode2 {


    int val;
    List<TreeNode2> children;

    TreeNode2(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class SubTree_With_Maximum_Average {

    double max = Integer.MIN_VALUE;
    TreeNode2 maxNode = null;

    public TreeNode2 maximumAverageSubtree(TreeNode2 root) {
        if (root == null) {
            return null;
        }

        helper(root);
        return maxNode;
    }

    private double[] helper(TreeNode2 node) {
        if (node == null) {
            return new double[]{0, 0};
        }

        double currTotal = node.val;
        double currCount = 1;
        for (TreeNode2 child : node.children) {
            double[] curr = helper(child);
            currTotal += curr[0];
            currCount += curr[1];
        }

        double avg = (currTotal / currCount);
        if (currCount > 1 && avg > max) {
            max = avg;
            maxNode = node;
        }
        return new double[]{currTotal, currCount};


    }
}


/**
 * Solution for binary tree:
 * Lintcode : leetcode like different website
 */
class BinaryTreeSolution {
    /**
     * Definition of TreeNode:
     * public class TreeNode {
     * public int val;
     * public TreeNode left, right;
     * public TreeNode(int val) {
     * this.val = val;
     * this.left = this.right = null;
     * }
     * }
     */

    public class Solution {

        private class Result {
            int sum, num;

            public Result(int sum, int num) {
                this.sum = sum;
                this.num = num;
            }
        }

        private TreeNode maxAvgNode = null;
        private Result maxAvg = null;

        /**
         * @param root: the root of binary tree
         * @return: the root of the maximum average of subtree
         */
        public TreeNode findSubtree2(TreeNode root) {
            if (root == null)
                return null;
            dfs(root);
            return maxAvgNode;
        }

        private Result dfs(TreeNode root) {
            if (root == null)
                return new Result(0, 0);

            Result left = dfs(root.left);
            Result right = dfs(root.right);
            Result rootResult = new Result(left.sum + right.sum + root.value, left.num + right.num + 1);
            if (maxAvgNode == null || rootResult.sum * maxAvg.num > maxAvg.sum * rootResult.num) {
                maxAvg = rootResult;
                maxAvgNode = root;
            }
            return rootResult;
        }
    }
}
