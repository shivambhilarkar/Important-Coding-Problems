package LinkedList;

import java.util.ArrayList;

public class Q02_Merge_two_sorted_linkedList {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2, ArrayList<Integer> Collections) {
            // Brute force solution
            ArrayList<Integer> list = new ArrayList<>();
            get_nodes(list1, list);
            get_nodes(list2, list);
            // Collections.sort(list);

            ListNode head = new ListNode(0);
            ListNode temp = head;
            int index = 0;
            while (index < list.size()) {
                temp.next = new ListNode(list.get(index++));
                temp = temp.next;
            }
            return head.next;
        }
    }

    public void get_nodes(ListNode head, ArrayList<Integer> list) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    // Optimise Solution
    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode Head = new ListNode(0);
            ListNode temp = Head;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                temp = temp.next;
            }
            if (list1 != null) {
                temp.next = list1;
            }
            if (list2 != null) {
                temp.next = list2;
            }
            return Head.next;
        }
    }

}