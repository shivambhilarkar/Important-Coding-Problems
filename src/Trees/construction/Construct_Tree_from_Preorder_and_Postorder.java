package Trees.construction;

import java.util.HashMap;
import java.util.Map;

public class Construct_Tree_from_Preorder_and_Postorder {

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        int[] preIndex = {0};
        return buildTree(preIndex, preorder, 0, postorder.length - 1, postorder, postMap);
    }

    private TreeNode buildTree(int[] preIndex, int[] preorder, int postStart, int postEnd, int[] postorder, Map<Integer, Integer> postMap) {
        if (postStart > postEnd) {
            return null;
        }

        int preStart = preIndex[0];
        TreeNode node = new TreeNode(preorder[preStart]);
        preIndex[0] = preStart + 1;

        if (postStart == postEnd) {
            return node;
        }
        int mid = postMap.get(preorder[preStart + 1]);

        node.left = buildTree(preIndex, preorder, postStart, mid, postorder, postMap);
        node.right = buildTree(preIndex, preorder, mid + 1, postEnd - 1, postorder, postMap);

        return node;

    }
}
