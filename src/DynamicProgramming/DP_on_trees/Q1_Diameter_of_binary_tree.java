package DynamicProgramming.DP_on_trees;

public class Q1_Diameter_of_binary_tree {


    static int result = Integer.MIN_VALUE;
    public static int getMaxDiameter(TreeNode root){
        if(root == null) return 0;

        int left = getMaxDiameter(root.left);
        int right = getMaxDiameter(root.right);

        //left or right is going to future diameter
        int currentIsNotDiameter = Math.max(left, right) + 1;

        //current diameter which goes through left & right
        int currentIsDiameter = left + right + 1;

        result = Math.max(currentIsDiameter, currentIsNotDiameter);

        return currentIsNotDiameter;
    }


    public static void main(String[] args) {

    }

}
