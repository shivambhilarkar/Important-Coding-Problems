package Trees;

import java.util.ArrayList;
import java.util.List;

public class N_array_postorder_traversal {

    // * // Definition for a Node.
    public class TreeNode {
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

    class Solution {
        public List<Integer> postorder(Node root) {
            ArrayList<Integer> list = new ArrayList<>();
            postorder_traversal(root, list);
            return list;
        }

        public void postorder_traversal(Node root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
            for (int i = 0; i < root.children.size(); i++) {
                postorder_traversal(root.children.get(i), list);
            }
            list.add(root.val);
        }
    }

}
