package DynamicProgramming.DP_on_trees;

public class Q3_House_Robber_III {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Pair {
        int rob = 0;
        int dontRob = 0;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair();
        }

        Pair leftHouses = dfs(root.left);
        Pair rightHouses = dfs(root.right);

        Pair current = new Pair();

        current.rob = leftHouses.dontRob + rightHouses.dontRob + root.value;
        current.dontRob = Math.max(leftHouses.dontRob, leftHouses.rob) +
                Math.max(rightHouses.dontRob, rightHouses.rob);

        return current;
    }


    public int rob(TreeNode root) {
        Pair robber = dfs(root);
        return Math.max(robber.rob, robber.dontRob);
    }

}
