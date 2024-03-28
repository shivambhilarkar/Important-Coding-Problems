package LinkedList;

import java.util.TreeSet;

public class Q04_Delete_Duplicate_nodes {
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

    // Brute Force Solution
    class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            TreeSet<Integer> set = new TreeSet<>();
            while (head != null) {
                set.add(head.val);
                head = head.next;
            }
            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;
            for (int num : set) {
                temp.next = new ListNode(num);
                temp = temp.next;
            }
            return dummy.next;
        }
    }

    // Optimise Solution
    class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null)
                return null;

            ListNode temp = head;
            while (temp.next != null) {
                // if we incounter duplicate value
                if (temp.val == temp.next.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            return head;
        }
    }
}
