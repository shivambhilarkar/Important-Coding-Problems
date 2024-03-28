package DynamicProgramming.DP_on_trees;

public class Q1_Maximum_sum_path_any_node_to_node {


    static int result = Integer.MIN_VALUE;
    public static int maxSumPath(TreeNode root){
        if(root == null) return 0;

        int left = maxSumPath(root.left);
        int right = maxSumPath(root.right);

        int currentIsPath = left + right + root.value;
        int currentIsNotPath = Math.max(left, right) + root.value;
        int currentIsStart = root.value;

        int maxOfThree = Math.max(currentIsPath, Math.max(currentIsNotPath, currentIsStart));

        result = Math.max(maxOfThree, result);

        return Math.max(currentIsStart, currentIsNotPath);
    }


    public static void main(String[] args) {

    }
}
