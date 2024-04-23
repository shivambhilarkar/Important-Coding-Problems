package OA;

import java.util.PriorityQueue;

public class Q_11_Merge_two_sorted_list {

    // Definition for singly-linked list.
    class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while (list1 != null) {
            queue.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            queue.add(list2.val);
            list2 = list2.next;
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (queue.isEmpty() == false) {
            ListNode node = new ListNode(queue.poll());
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }
}
