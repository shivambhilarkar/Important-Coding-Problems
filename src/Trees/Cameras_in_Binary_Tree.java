package Trees;

public class Cameras_in_Binary_Tree {
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

    public int getMinCamerasToCover(TreeNode node, int[] camera) {
        //null nodes don't need to cover assume already covered
        if (node == null) {
            return 1;
        }

        int leftChild = getMinCamerasToCover(node.left, camera);
        int rightChild = getMinCamerasToCover(node.right, camera);

        //if any of child required camera , will install it on parent node
        if (leftChild == -1 || rightChild == -1) {
            camera[0] += 1;
            return 0;
        }

        //if any of child have camera, parent will not need
        if (leftChild == 0 || rightChild == 0) {
            return 1;
        }

        //else current node require camera
        return -1;
    }


    public int minCameraCover(TreeNode root) {
        int[] result = new int[1];
        int rootNeedCamera = getMinCamerasToCover(root, result);
        if (rootNeedCamera == -1) {
            result[0] += 1;
        }
        return result[0];

    }


}
