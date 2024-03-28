package LinkedList.LinkedListHard;

class Q02_Reverse_Nodes_in_k_groups {
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

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head; // join the dummyhead;
            ListNode temp = dummyHead;

            while (temp != null) {
                ListNode node = temp;
                for (int i = 0; i < k && node != null; i++) {
                    node = node.next;
                }
                if (node == null)
                    break; // less than k size group

                ListNode prevNode = null;
                ListNode currNode = temp.next;
                ListNode nextNode = null;
                for (int i = 0; i < k; i++) {
                    nextNode = currNode.next;
                    currNode.next = prevNode;
                    prevNode = currNode;
                    currNode = nextNode;
                }

                ListNode tail = temp.next;
                tail.next = currNode;
                temp.next = prevNode;
                temp = tail;

            }
            return dummyHead.next;
        }
    }
}