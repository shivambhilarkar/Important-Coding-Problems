package LinkedList;

public class Q07_Swap_LinkedList_Node {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // optimise approach o(1) space & o(n) complexity
    class Solution {
        public ListNode swapNodes(ListNode head, int k) {

            ListNode slow = head;
            ListNode fast = head;

            for (int i = 0; i < k - 1; i++) {
                fast = fast.next;
            }
            int kthFirst = fast.val; // store kth first value
            ListNode kthF = fast; // store kth first Node
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            int kthLast = slow.val; // kth last value === kth first value
            slow.val = kthFirst;
            kthF.val = kthLast; // kth first value === kthe last value
            return head;
        }
    }

}
