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
