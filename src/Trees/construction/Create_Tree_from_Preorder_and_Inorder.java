package Trees.construction;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
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

public class Create_Tree_from_Preorder_and_Inorder {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //store the inorder with index in map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, inorder, 0, preorder.length - 1, preorder, map);
    }


    public TreeNode buildTree(int inStart, int inEnd, int[] inorder, int preStart, int preEnd, int[] preorder, Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int inRoot = map.get(node.val);
        int numsOnLeft = inRoot - inStart;

        node.left = buildTree(inStart, inRoot - 1, inorder,
                preStart + 1, preStart + numsOnLeft, preorder, map);

        node.right = buildTree(inRoot + 1, inEnd, inorder,
                preStart + numsOnLeft + 1, preEnd, preorder, map);

        return node;
    }


}
