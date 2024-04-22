package OA;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q_02_Height_Of_Tree {


    //TreeNode
    static class TreeNode {
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

    /**
     * Get Max Depth
     * Get Height of Tree
     * @return Integer
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth += 1;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return depth;
    }

}
