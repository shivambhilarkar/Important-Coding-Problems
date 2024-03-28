package LinkedList.LinkedListHard;

import java.util.PriorityQueue;

//Important Note : If the input is given in the form of array , then use the pair class which store the current value and row , col.

public class Q01_Merge_sorted_lists {
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

    // Optimise Approach
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                return null;
            // Priority queue with custom comparable..
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode head : lists) {
                if (head != null) {
                    queue.add(head);
                }
            }

            ListNode dummyHead = new ListNode(-1);
            ListNode temp = dummyHead;
            while (queue.isEmpty() == false) {
                ListNode curr = queue.remove();
                temp.next = new ListNode(curr.val);
                temp = temp.next;
                if (curr.next != null) {
                    queue.add(curr.next);
                }
            }
            return dummyHead.next;
        }
    }

}
