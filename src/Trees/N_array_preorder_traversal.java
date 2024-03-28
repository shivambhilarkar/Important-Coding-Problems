package Trees;

public class N_array_preorder_traversal {

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
        public List<Integer> preorder(Node root) {
            List<Integer> list = new ArrayList<>();
            preorder_Traversal(root, list);
            return list;
        }

        public void preorder_Traversal(Node root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                preorder_Traversal(root.children.get(i), list);
            }
        }
    }

}
