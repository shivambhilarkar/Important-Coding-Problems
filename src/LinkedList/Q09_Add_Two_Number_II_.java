package LinkedList;

import java.util.Stack;

public class Q09_Add_Two_Number_II_ {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            // rev first list through stack
            Stack<Integer> list1 = new Stack<>();
            while (l1 != null) {
                list1.push(l1.val);
                l1 = l1.next;
            }
            // rev second list through stack
            Stack<Integer> list2 = new Stack<>();
            while (l2 != null) {
                list2.push(l2.val);
                l2 = l2.next;
            }

            int carry = 0;
            ListNode head = null;
            while (!list1.isEmpty() || !list2.isEmpty() || carry != 0) {
                int top1 = list1.isEmpty() ? 0 : list1.pop();
                int top2 = list2.isEmpty() ? 0 : list2.pop();

                int sum = top1 + top2 + carry;
                ListNode node = new ListNode(sum % 10);
                node.next = head;
                head = node;

                carry = sum / 10;
            }
            return head;

        }
    }
}
