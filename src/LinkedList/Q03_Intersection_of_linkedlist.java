package LinkedList;

public class Q03_Intersection_of_linkedlist {
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

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int list1_size = size(headA);
            int list2_size = size(headB);

            if (list1_size < list2_size) {
                for (int i = 0; i < list2_size - list1_size; i++) {
                    headB = headB.next;
                }
            } else if (list2_size < list1_size) {
                for (int i = 0; i < list1_size - list2_size; i++) {
                    headA = headA.next;
                }
            }

            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        public int size(ListNode head) {
            int count = 0;
            while (head != null) {
                head = head.next;
                count += 1;
            }
            return count;
        }
    }

}
