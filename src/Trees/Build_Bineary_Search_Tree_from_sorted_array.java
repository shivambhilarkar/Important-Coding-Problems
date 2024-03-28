package Trees;

public class Build_Bineary_Search_Tree_from_sorted_array {
    // Definition for a binary tree node.
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return build_bst(nums, 0, nums.length - 1);
        }

        public TreeNode build_bst(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            int mid = (start + end) / 2;
            TreeNode dummy = new TreeNode(nums[mid]);
            dummy.left = build_bst(nums, start, mid - 1);
            dummy.right = build_bst(nums, mid + 1, end);
            return dummy;
        }
    }
}
