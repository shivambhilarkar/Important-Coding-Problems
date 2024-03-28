package Trees;// Given the root of a binary search tree, rearrange the tree in in-order so that
// the leftmost node in the tree is now the root of the tree,
//  and every node has no left child and only one right child.

public class increasing_order_search_tree {
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
        public TreeNode increasingBST(TreeNode root) {
            // get the element
            // create new tree
            // add to right

            ArrayList<Integer> list = new ArrayList<>();
            inorder(root, list);

            TreeNode dummy = new TreeNode(0);
            TreeNode temp = dummy;
            for (int num : list) {
                temp.right = new TreeNode(num);
                temp = temp.right;
            }
            return dummy.right;

        }

        public void inorder(TreeNode root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }

            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);

        }
    }

}
