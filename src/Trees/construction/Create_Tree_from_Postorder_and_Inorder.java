package Trees.construction;

import java.util.HashMap;
import java.util.Map;

public class Create_Tree_from_Postorder_and_Inorder {

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder, map);
    }

    private TreeNode buildTree(int inStart, int inEnd, int[] inorder, int postStart, int postEnd, int[] postorder,
                               Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(node.val);
        int numsOnLeft = inRoot - inStart;

        node.left = buildTree(inStart, inRoot - 1, inorder, postStart, postStart + numsOnLeft - 1, postorder, map);

        node.right = buildTree(inRoot + 1, inEnd, inorder, postStart + numsOnLeft, postEnd - 1, postorder, map);

        return node;
    }
}
